package org.seckill.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 返回格式 JSON
 */
public class CommonRequestJSON {

    public static void toJSON(CommonRequest commonRequest, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();
        String jsonObject = JSONObject.toJSONString(commonRequest,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect);
        printWriter.write(jsonObject);
        printWriter.close();
    }
}
