package com.tensquare.qa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
@MapperScan("com.tensquare.qa.dao")
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
    }

    @Bean
    IdWorker idWorker() {
        return new IdWorker();
    }
}
