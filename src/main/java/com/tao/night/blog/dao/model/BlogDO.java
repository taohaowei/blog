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
@TableName("t_blog")
public class BlogDO {
    /**
     * 博客id，主键、索引、自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客摘要
     */
    private String summary;

    /**
     * 博客创建时间
     */
    private Date createTime;

    /**
     * 博客类型，1原创、2转载、3翻译，4收藏
     */
    private Integer type;

    /**
     * 博客 文章分类
     */
    private String blogType;

    /**
     * 阅读量
     */
    private Integer viewCount;

    /**
     * 评论量
     */
    private Integer commentCount;

    /**
     * 文章内容
     */
    private String context;

    /**
     * 博客摘要图片
     */
    private String summaryImg;

    /**
     * 博客内容图片
     */
    private String contextImg;

}
