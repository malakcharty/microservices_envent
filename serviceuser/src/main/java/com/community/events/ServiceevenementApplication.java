package com.community.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceevenementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceevenementApplication.class, args);
    }

}
