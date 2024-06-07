package com.tina.batch.common.logging;

import com.tina.batch.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionLoggerTest {

    @Test
    @DisplayName("reflection logger를 통해 원하는 컬럼만 로깅하는데 성공한다.")
    void testSuccess() {
        List<Person> before = new ArrayList<>();
        before.add(new Person("Tina", "Jeong"));
        String loggingMessage = ReflectionLogger.logError(before.get(0), "lastName");
        Assertions.assertThat(loggingMessage).contains("Jeong");
        Assertions.assertThat(loggingMessage).contains("lastName");
        Assertions.assertThat(loggingMessage).doesNotContain("Tina");
    }

}