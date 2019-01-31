package org.seckill.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 封装正则表达式验证工具类
 * 分成 常规正则验证 和 验证的主要方法
 */
public class Verify {

    /**
     * 1. 非零的正整数
     */
    private static final String IS_NOT_NULL = "\"^[1-9]\\\\d*$\"";


    /**
     * 全局判断
     */
    private static boolean verify(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
