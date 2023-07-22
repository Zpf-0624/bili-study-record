package com.tuyoo.bi.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Objects;

/**
 * growanalyticsudf:
 *
 * @date: 2022/5/18
 * @Author: Nicky.Zhang
 */
public class columnToProperties {

    public String evaluate(String properties, String fieldAndVale) {
        return columnTo(properties,fieldAndVale).toJSONString();
    }


    public static JSONObject columnTo(String properties, String fieldAndVale){
        JSONObject jsonObject;
        if(Objects.isNull(properties) || "".equals(properties)){
            jsonObject = new JSONObject();
        }else {
            try {
                jsonObject = JSON.parseObject(properties);
            }catch (Exception e){
                jsonObject = new JSONObject();
            }

        }
        if (fieldAndVale.endsWith("::")) {
            fieldAndVale = fieldAndVale + " ";
        }

        String[] split = fieldAndVale.split("::");
        for(int i = 0; i < split.length; i += 2) {
            try {
                if(i + 1 < split.length && !jsonObject.containsKey(split[i]) && !"$ga-null$".equals(split[i + 1])){
                    jsonObject.put(split[i], split[i + 1]);
                }
            }catch (Exception e){
                continue;
            }
        }

        return jsonObject;
    }

    public static void main(String[] args) {
        System.out.println(columnTo("", "test::$ga-null$::test1::aaa").toJSONString());
    }
}
