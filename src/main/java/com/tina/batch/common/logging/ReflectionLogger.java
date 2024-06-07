package com.tina.batch.common.logging;

import com.tina.batch.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ReflectionLogger {

    public static String logError(Object obj, String... fieldNames) {
        StringBuilder logMessage = new StringBuilder(obj.getClass().getSimpleName()+ "={");
        for (String fieldName : fieldNames) {
            try {
                Field field = obj.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(obj);
                logMessage.append(fieldName).append("=").append(value).append(", ");
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                return "";
            }
        }
        logMessage.append("}");
        return logMessage.toString();
    }

    public static void main(String[] args) {
        List<Person> before = new ArrayList<>();
        before.add(new Person("Tina", "Jeong"));
        before.add(new Person("Chanmi", "Jeong"));
        try {

            List<Person> result = before.stream().filter(p -> p.getLastName().equals("Jeong")).toList();

            throw new IllegalArgumentException("아무튼 잘못됨");
        } catch (Exception e) {
            log.error(ReflectionLogger.logError(before.get(0), "lastName"));
        }

    }
}
