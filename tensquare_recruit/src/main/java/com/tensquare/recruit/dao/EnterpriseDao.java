package com.tensquare.recruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.recruit.entity.Enterprise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EnterpriseDao extends BaseMapper<Enterprise> {

}