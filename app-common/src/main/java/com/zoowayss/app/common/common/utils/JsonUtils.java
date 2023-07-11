package com.zoowayss.app.common.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description:
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-04-25
 */
public class JsonUtils {
    private static final ObjectMapper jsonMapper = new ObjectMapper();

    public static <T> T toObj(String str, Class<T> clz) {
        try {
            return jsonMapper.readValue(str, clz);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public static String toStr(Object t) {
        try {
            return jsonMapper.writeValueAsString(t);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
