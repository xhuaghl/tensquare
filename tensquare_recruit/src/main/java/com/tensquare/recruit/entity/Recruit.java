package com.tensquare.recruit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 职位(TbRecruit)实体类
 *
 * @author makejava
 * @since 2020-03-14 11:23:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_recruit")
public class Recruit implements Serializable {
    private static final long serialVersionUID = 549360947834040577L;
    /**
    * ID
    */
    private String id;
    /**
    * 职位名称
    */
    private String jobname;
    /**
    * 薪资范围
    */
    private String salary;
    /**
    * 经验要求
    */
    @TableField("`condition`")
    private String condition;
    /**
    * 学历要求
    */
    private String education;
    /**
    * 任职方式
    */
    private String type;
    /**
    * 办公地址
    */
    private String address;
    /**
    * 企业ID
    */
    private String eid;
    /**
    * 创建日期
    */
    private Date createtime;
    /**
    * 状态
    */
    private String state;
    /**
    * 网址
    */
    private String url;
    /**
    * 标签
    */
    private String label;
    /**
    * 职位描述
    */
    private String content1;
    /**
    * 职位要求
    */
    private String content2;



}