package com.tensquare.qa.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.qa.entity.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问题(Problem)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-14 13:31:55
 */
@Component
public interface ProblemDao extends BaseMapper<Problem> {


    IPage<Problem> newList(IPage<Problem> page,
                           @Param("labelId") String labelId);

    @Select("select id, title, content, createtime, updatetime, userid, " +
            "nickname, visits, thumbup, reply, solve, replyname, replytime " +
            "from tb_problem,tb_pl where id = problemid and labelid = #{labelId} order by reply DESC")
    IPage<Problem> hotList(IPage<Problem> page,
                           @Param("labelId") Integer labelId);
}