package com.sms.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.sms.common.entity"})
public class SchoolManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementBackendApplication.class, args);
	}

}
