package com.tao.night.blog.dao.model;

import lombok.Data;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客文章分类，mysql、java、计算机网络、等等
 */
@Data
public class BlogType {
    /**
     * 博客文章分类id，自增
     */
    private Long id;

    /**
     * 博客文章分类名称
     */
    private String typeName;

}
