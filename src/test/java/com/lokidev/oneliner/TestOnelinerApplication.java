package com.lokidev.oneliner;

import org.springframework.boot.SpringApplication;

public class TestOnelinerApplication {

	public static void main(String[] args) {
		SpringApplication.from(OnelinerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
