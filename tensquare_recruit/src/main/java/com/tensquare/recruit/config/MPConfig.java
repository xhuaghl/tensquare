package com.tensquare.recruit.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //开启事务管理
@MapperScan("com.tensquare.recruit.dao")
public class MPConfig {

    //MyBatis-plus分页配置
    @Bean //别忘记加入容器
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
