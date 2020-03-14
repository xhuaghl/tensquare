package com.tensquare.recruit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 企业(TbEnterprise)实体类
 *
 * @author makejava
 * @since 2020-03-14 10:32:26
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_enterprise")
public class Enterprise implements Serializable {
    private static final long serialVersionUID = 586643904015434296L;
    /**
     * ID
     */
    private String id;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业简介
     */
    private String summary;
    /**
     * 企业地址
     */
    private String address;
    /**
     * 标签列表
     */
    private String labels;
    /**
     * 坐标
     */
    private String coordinate;
    /**
     * 是否热门
     */
    private String ishot;
    /**
     * LOGO
     */
    private String logo;
    /**
     * 职位数
     */
    private Integer jobcount;
    /**
     * URL
     */
    private String url;

}