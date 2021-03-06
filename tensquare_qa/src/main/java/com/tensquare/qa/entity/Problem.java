package com.tensquare.qa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 问题(TbProblem)实体类
 *
 * @author makejava
 * @since 2020-03-14 13:31:54
 */
@Data
@TableName("tb_problem")
public class Problem implements Serializable {
    private static final long serialVersionUID = 617389878740889159L;
    /**
     * ID
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建日期
     */
    private Date createtime;
    /**
     * 修改日期
     */
    private Date updatetime;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 浏览量
     */
    private Long visits;
    /**
     * 点赞数
     */
    private Long thumbup;
    /**
     * 回复数
     */
    private Long reply;
    /**
     * 是否解决
     */
    private String solve;
    /**
     * 回复人昵称
     */
    private String replyname;
    /**
     * 回复日期
     */
    private Date replytime;
}