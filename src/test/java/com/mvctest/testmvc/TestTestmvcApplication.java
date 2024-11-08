package com.mvctest.testmvc;

import org.springframework.boot.SpringApplication;

public class TestTestmvcApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestmvcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
