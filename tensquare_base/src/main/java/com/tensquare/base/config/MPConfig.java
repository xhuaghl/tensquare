package com.tensquare.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //开启事务管理
@MapperScan("com.tensquare.base.dao")
public class MPConfig  {

    @Bean //别忘记加入容器
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
