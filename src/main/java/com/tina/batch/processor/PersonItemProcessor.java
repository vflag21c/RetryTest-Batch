package com.tina.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.tina.batch.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) {
        person.setLastName(person.getLastName() + "B");
        return person;
    }

}