package com.yff.roomsMng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.yff.roomsMng.dao")
@SpringBootApplication
public class QuickStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuickStartApplication.class, args);
	}
}
