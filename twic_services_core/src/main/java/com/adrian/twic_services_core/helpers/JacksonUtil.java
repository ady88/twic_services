package com.adrian.twic_services_core.helpers;

import java.util.Arrays;
import org.springframework.util.SerializationUtils;

public class JacksonUtil {

    public static <T> T fromString(String string, Class<T> clazz) {
        return (T) SerializationUtils.deserialize(string.getBytes());
    }

    public static String toString(Object value) {
        return Arrays.toString(SerializationUtils.serialize(value));
    }

    public static <T> T clone(T value) {
        return fromString(toString(value), (Class<T>) value.getClass());
    }
}
