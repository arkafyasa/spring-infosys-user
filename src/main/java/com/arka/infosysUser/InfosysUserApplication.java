package com.arka.infosysUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.arka.infosysUser", "com.arka.infosysUser.controller"})
@ComponentScan({"controller", "service"})
public class InfosysUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfosysUserApplication.class, args);
	}

}
