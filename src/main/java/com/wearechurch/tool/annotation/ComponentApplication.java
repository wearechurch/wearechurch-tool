package com.wearechurch.tool.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.wearechurch")
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
public @interface ComponentApplication {
}
