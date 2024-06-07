package com.tina.batch.entity.repository;

import com.tina.batch.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("lastName으로 저장된 person 조회에 성공한다.")
    void selectSuccess() {
        List<Person> person =  personRepository.findByLastName("Jeong");
        assertEquals(1, person.size());
    }


    @Test
    @DisplayName("동일한 쿼리로 Query Plan Cache 작동 여부를 확인한다.")
    void checkQueryPlanCache() {
        List<Person> person2 =  personRepository.findByFirstNameAndLastName("Chanmi", "Jeong");
        List<Person> person3 =  personRepository.findByFirstNameAndLastName("Tina", "Kim");
    }
}