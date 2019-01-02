package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.entity.Users;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillSerivce;
import org.seckill.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Sori
 */
@Controller
@RequestMapping("/seckill") //url: 模块/资源/id ->   seckill/list ;指定路径
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillSerivce seckillSerivce;

    @Autowired
    private UsersService usersService;

    /**
     * 列表信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) {
        Users session = (Users) request.getSession().getAttribute("USERS_SESSION");
        if (null != session) {

            // list.jsp + model = ModelAndView
            List<Seckill> list = seckillSerivce.getSeckillList();

            Users users = usersService.queryUsersById(session.getId());
            if (null == users) {
                return "ERROR";
            }
            model.addAttribute("userName", session.getUserName());
            model.addAttribute("list", list);
            int pageNumber = 10;

            // 分页查询
            String page = request.getParameter("page");
            if (null != page) {
                model.addAttribute("pageNow", page);
            } else {
                model.addAttribute("pageNow", 1);
            }

            model.addAttribute("pageNumber", pageNumber);
            model.addAttribute("totalPage", list.size());

            return "list"; // 在 spring-web.xml 中已经指定了 JSP 在 /WEB_INF/jsp，相当于 /WEB-INF/"list".jsp 前缀和后缀都已经指定了，只需要返回个 list 就可以了
        } else {
            return "redirect:/users/login";
        }
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    @ResponseBody
    public String getId(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (null != id) {
            return "0";
        }
        return "-1";
    }

    /**
     * 添加用户并创建时间
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request, Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("createTime", simpleDateFormat.format(new Date()));
        return "add";
    }

    /**
     * 编辑
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Model model) {
        String getId = request.getParameter("id");
        if (! "".equals(getId) && null != getId) {
            Long id = Long.valueOf(getId);
            Seckill getSeckillById = seckillSerivce.getById(id);
            model.addAttribute("seckillId", getSeckillById.getSeckillId());
            model.addAttribute("name", getSeckillById.getName());
            model.addAttribute("number", getSeckillById.getNumber());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            model.addAttribute("startTime", simpleDateFormat.format(getSeckillById.getStartTime()));
            model.addAttribute("endTime", simpleDateFormat.format(getSeckillById.getEndTime()));
            model.addAttribute("createTime", simpleDateFormat.format(getSeckillById.getCreateTime()));
        }
        return "edit";
    }

    /**
     * 保存
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request) throws ParseException {
        String id = request.getParameter("id");
        Seckill seckill = new Seckill();
        if (null != id) {
            seckill = seckillSerivce.getById(Long.parseLong(id));
        }

        String name = request.getParameter("name");
        Integer number = Integer.valueOf(request.getParameter("number"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simpleDateFormat.parse(request.getParameter("startTime"));
        Date endTime = simpleDateFormat.parse(request.getParameter("endTime"));
        Date createTime = simpleDateFormat.parse(request.getParameter("createTime"));
        seckill.setName(name);
        seckill.setNumber(number);
        seckill.setStartTime(startTime);
        seckill.setEndTime(endTime);
        seckill.setCreateTime(createTime);
        if ("".equals(id) || null == id) {
            seckillSerivce.addOrders(seckill);
            return "1";
        } else {
            seckillSerivce.updateOrders(seckill);
            return "0";
        }
    }

    /**
     * 删除
     * @param request
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public String del(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (null != id) {
            Seckill seckill = seckillSerivce.getById(Long.parseLong(id));
            seckillSerivce.deleteOrders((int) seckill.getSeckillId());
            return "0";
        } else {
            return "-1";
        }
    }

    /**
     * 待还原列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/recycleBinList", method = RequestMethod.GET)
    public String recycleBinList(HttpServletRequest request, Model model) {
        List<Seckill> seckillList = seckillSerivce.recycleBinList();
        model.addAttribute("list", seckillList);
        int pageNumber = 10;

        // 分页查询
        String page = request.getParameter("page");
        if (null != page) {
            model.addAttribute("pageNow", page);
        } else {
            model.addAttribute("pageNow", 1);
        }

        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPage", seckillList.size());
        return "recycleBin";
    }

    /**
     * 逻辑删除操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/logicallyDeleted", method = RequestMethod.POST)
    @ResponseBody
    public String logicallyDeleted(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (null != id) {
            Seckill seckill = seckillSerivce.getById(Long.parseLong(id));
            if (seckill.getStatus().equals(0)) {
                seckill.setStatus(1);
            } else if (seckill.getStatus().equals(1)) {
                seckill.setStatus(0);
            } else {
                return "-2";
            }
            seckillSerivce.logicallyDeleted(seckill);
            return "0";
        } else {
            return "-1";
        }
    }

    /*************************************  详细页 *****************************************************/

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) { //@PathVariable 占位符注解

        if (seckillId == null) {
            return "redirect:/seckill/list"; // 重定向到 seckill 模块下的 list 界面
        }
        Seckill seckill = seckillSerivce.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list"; // 请求转发到 seckill 模块下的 list 界面
        }
        model.addAttribute("seckill", seckill);
        return "detail"; //同样的，这里由于我们已经在 spring-web.xml 中指定了目录，前后缀都已经有了，所以我们只需要指定 detail 就可以了，完整的路径相当于 /WEB_INF/"detail".jsp
    }

    // AJAX 接口，返回JSON字符串
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST)
    @ResponseBody
    public SeckillResult<Exposer> exposer(long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillSerivce.exposerSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST)
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") long seckillId,

                                                   @PathVariable("md5") String md5,

                                                   // 如果请求过来的参数中没有这个 Cookie -> killPhone，就会报错，所以通过 required 告诉Spring MVC 这个 killPhone 不是必须的
                                                   @CookieValue(value = "killPhone", required = false) Long phone) {

        if (phone == null) {
            return new SeckillResult<>(false, "没有注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            // 调用存储过程
            SeckillExecution execution = seckillSerivce.executionSeckillProcedure(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        }catch (SeckillCloseException e1) {
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        }catch (SeckillException e2) {
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult<Long>(true, now.getTime());
    }
}
