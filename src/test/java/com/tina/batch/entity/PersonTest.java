package com.tina.batch.entity;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {

	@Test
	@DisplayName("FixtureMonkey로 person 객체 생성에 성공한다.")
	void testFixtureMonkeySuccess() {
		// given
		FixtureMonkey sut = FixtureMonkey.builder()
				.objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
				.build();

		// 특정한 값을 세팅하고 싶을때 builder 사용
		ArbitraryBuilder<Person> actual = sut.giveMeBuilder(Person.class)
			.set("firstName", "Tina");
//		System.out.println(actual.sample());
//		System.out.println(actual.sampleList(10));

		// sut로부터 default 값으로 객체 생성
		List<Person> personList = sut.giveMe(Person.class, 10);
	}

}