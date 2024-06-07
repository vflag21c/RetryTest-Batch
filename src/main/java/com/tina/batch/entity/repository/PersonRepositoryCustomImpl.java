package com.tina.batch.entity.repository;

import java.util.List;

import com.tina.batch.entity.Person;
import com.tina.batch.entity.QPerson;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PersonRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        QPerson person = QPerson.person;
        return queryFactory
                .selectFrom(person)
                .where(person.firstName.eq(firstName))
                .fetch();
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        QPerson person = QPerson.person;
        return queryFactory
                .selectFrom(person)
                .where(person.lastName.eq(lastName))
                .fetch();
    }


    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        QPerson person = QPerson.person;
        return queryFactory
                .selectFrom(person)
                .where(person.firstName.eq(firstName), person.lastName.eq(lastName))
                .fetch();
    }
}
