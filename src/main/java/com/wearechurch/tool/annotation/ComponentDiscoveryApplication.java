package com.wearechurch.tool.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.wearechurch")
@EnableDiscoveryClient
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
public @interface ComponentDiscoveryApplication {
}
