package com.tao.night.blog.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客文章的实体类
 */
@Data
@TableName("t_blogContext")
public class BlogContextDO {
    /**
     * 博客id，主键、索引、自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 文章内容
     */
    private String context;

    /**
     * 是否为MarkDown文本存储，1为是，0为不是。默认0
     */
    private Boolean isMD;

}
