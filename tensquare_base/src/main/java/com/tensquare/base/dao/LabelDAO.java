package com.tensquare.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.base.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
public interface LabelDAO extends BaseMapper<Label> {

}
