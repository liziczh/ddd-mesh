package com.liziczh.ddd.mesh.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
public class JsonUtils {
    protected final static Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * Object to JSON
     *
     * @param object object
     * @return json
     */
    public static String toJSONString(Object object) {
        String json = null;
        try {
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.debug("Object转换JSON发生错误", e);
        }
        return json;
    }

    /**
     * JSON to Object
     *
     * @param json  json
     * @param clazz class
     * @param <T>   genericity
     * @return Object
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.debug("JSON转换Object发生错误", e);
        }
        return object;
    }

    /**
     * JSON to List
     *
     * @param json  json
     * @param clazz object class
     * @param <T>   Object genericity
     * @return List
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        List<T> result = null;
        try {
            result = mapper.readValue(json, javaType);
        } catch (Exception e) {
            log.debug("JSON转换List发生错误", e);
        }
        return result;
    }

    /**
     * JSON to Map
     *
     * @param json  json
     * @param key   map key cLass
     * @param value map value class
     * @param <K>   map key genericity
     * @param <V>   map value genericity
     * @return Map
     */
    public static <K, V> Map<K, V> parseMap(String json, Class<K> key, Class<V> value) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class, key, value);
        Map<K, V> result = null;
        try {
            result = mapper.readValue(json, javaType);
        } catch (Exception e) {
            log.debug("JSON转换Map发生错误", e);
        }
        return result;
    }
}
