package com.tina.batch.entity.repository;

import com.tina.batch.entity.Person;

import com.tina.batch.entity.PersonIdClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonIdClass>, PersonRepositoryCustom  {
}
