package com.pragma.powerup.usermicroservice;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMicroserviceApplicationTests {

	@Test
	void contextLoads() {

		OwnerEntity owner = new OwnerEntity();
		owner.setName("John");
		owner.setMail("char@gmail.com");
		owner.setPassword("dasdad");
		owner.setDniNumber(12345657L);
		System.out.println(owner);
	}
}
