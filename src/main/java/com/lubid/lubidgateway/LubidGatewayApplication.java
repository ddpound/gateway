package com.lubid.lubidgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LubidGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LubidGatewayApplication.class, args);
    }

}
