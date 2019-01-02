package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

// 不知道类型用 Component，如果是Service就用 @Service ，如果是Controller 就用@Controller
@Service
public class SeckillServiceImpl implements SeckillSerivce {

    // 注入 Service 依赖，J2E 规范有 @Resource、@Inject，但是这里我们用的Spring，所以直接采用 自动注入 @Autowired
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 加盐处理，混淆 MD5
    private String slat = "jiayanchuli,yongyuhunxiaomd5!";

    /******************************** 有26条数据 ***********************************/
    @Override
    public List<Seckill> getSeckillList() {

        int offset = 0;

        // 分页查询
        String page = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getParameter("page");
        if (!"".equals(page) && null != page) {
            offset = Integer.parseInt(page.trim());
        } else {
            offset = 1;
        }

        return seckillDao.queryAll((offset - 1) * 10, 10, 0);
    }

    /******************************* 根据 ID 来查询 *********************************/
    @Override
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /****************************** 秒杀开始前 ***************************************/
    @Override
    public Exposer exposerSeckillUrl(long seckillId) {

        // 1. 访问Redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (null == seckill) {
            // 2. 如果Redis中的数据为空则从数据库查
            seckill = seckillDao.queryById(seckillId);
            if (seckill == null) {
                // 如果数据库中依然为空则商品不存在
                return new Exposer(false, seckillId);
            } else {
                // 3. 否则把数据写入 Redis
                redisDao.putSeckill(seckill);
            }
        }


        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    //  为了能全局使用 MD5 和加盐，把
    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /***************************** 执行 抢购 *****************************************/
    @Override
    @Transactional
    /**
     * @author Sori
     * @Description 使用注解控制事务，在这里，执行抢购，才算是真正的事务管理，所以需要加上个 Transactional，让这个方法成为 事务方法
     *                  这个方法中，尽量干净，只存在对数据库的增删查改
     * @Date 15:18 2018/4/27
     * @param seckillId
    * @param userPhone
    * @param md5
     * @return org.seckill.dto.SeckillExecution
     */
    public SeckillExecution executionSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        // 秒杀业务逻辑
        try {
            // 记录购买行为
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                // 重复秒杀
                throw new RepeatKillException("seckill repeated");
            } else {
                int updateCount = seckillDao.reduceNumber(seckillId, Calendar.getInstance().getTime());
                if (updateCount <= 0) {
                    // 执行秒杀的时候，库存小于0，代表秒杀结束
                    throw new SeckillCloseException("seckill is closed");
                } else {
                    // 秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 把所有编译器异常转换为运行期异常
            throw new SeckillException("seckill inner error: " + e.getMessage());
        }
    }

    /**
     * 修改列表信息
     *
     * @param seckill
     * @return
     */
    @Override
    public int updateOrders(Seckill seckill) {
        return seckillDao.updateOrders(seckill);
    }

    /**
     * 删除对应列表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOrders(Integer id) {
        return seckillDao.deleteOrders(id);
    }

    /**
     * 添加信息
     *
     * @param seckill
     * @return
     */
    @Override
    public Integer addOrders(Seckill seckill) {
        return seckillDao.addorders(seckill);
    }

    /**
     * 待还原的列表
     *
     * @return
     */
    @Override
    public List<Seckill> recycleBinList() {
        int offset = 0;

        // 分页查询
        String page = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getParameter("page");
        if (!"".equals(page) && null != page) {
            offset = Integer.parseInt(page.trim());
        } else {
            offset = 1;
        }
        return seckillDao.queryAll((offset - 1) * 10, 10, 1);
    }

    /**
     * 逻辑删除对应列表信息
     *
     * @param status
     * @return
     */
    @Override
    public Integer logicallyDeleted(Seckill status) {
        return seckillDao.logicallyDeleted(status);
    }

    @Override
    public SeckillExecution executionSeckillProcedure(long seckillId, long userPhone, String md5) {
        if (null == md5 || !md5.equals(getMD5(seckillId))) {
            return new SeckillExecution(seckillId, SeckillStatEnum.DATA_REWRITE);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("seckillId", seckillId);
        map.put("phone", userPhone);
        map.put("killTime", new Date());
        map.put("result", -2);
        try {
            seckillDao.killByProcedure(map);
            // 获取 result
            int result = MapUtils.getInteger(map, "result", -2);
            if (result == 1) {
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
            } else {
                return new SeckillExecution(seckillId, Objects.requireNonNull(SeckillStatEnum.stateOf(result)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
        }
    }

}
