package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
/*
 * 程序只加载Application.java所在包及其子包下的内容 。
 * 方法一：将控制层(controller)放到 Application.java 的同层或它的子目录
 */
/*方法二
 * @ComponentScan(basePackages = {"com.yc.controller"})*/
public class HelloApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
}
