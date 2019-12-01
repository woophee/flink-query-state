package com.woophee.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@PropertySource(value="classpath:query-state-server.properties")
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);
    }
}
