package com.tina.batch.entity.repository;

import java.util.List;

import com.tina.batch.entity.Person;

public interface PersonRepositoryCustom {
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}