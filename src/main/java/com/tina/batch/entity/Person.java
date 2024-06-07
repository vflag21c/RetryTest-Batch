package com.tina.batch.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)   //주석 해제 시 무한루프 오류 발생
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@IdClass(PersonIdClass.class)
public class Person extends BasicAuditColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Id
    @Column(length = 8)
    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }
}

