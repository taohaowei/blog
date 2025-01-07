package com.tao.night.blog.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tao.night.blog.dao.BlogDAO;
import com.tao.night.blog.dao.model.BlogDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客mapper接口类
 */
@Component
public class BlogAdapter {

    @Autowired
    private BlogDAO blogDAO;

    /**
     * 插入一条博客信息，除id外，每个字段必须存在。
     */
    public Integer insertBlog(BlogDO blogDO) {
        return blogDAO.insert(blogDO);
    }

    /**
     * 更新一条博客信息，不为空字段，更新。id必须存在
     */
    public Integer updateBlog(BlogDO blogDO) {
        UpdateWrapper<BlogDO> updateWrapper = new UpdateWrapper<BlogDO>().eq("id", blogDO.getId());
        if (StringUtils.isNotBlank(blogDO.getTitle())) {
            updateWrapper.set("title", blogDO.getTitle());
        }
        if (StringUtils.isNotBlank(blogDO.getSummary())) {
            updateWrapper.set("summary", blogDO.getSummary());
        }
        if (StringUtils.isNotBlank(blogDO.getBlogType())) {
            updateWrapper.set("blogType", blogDO.getBlogType());
        }
        if (StringUtils.isNotBlank(blogDO.getContext())) {
            updateWrapper.set("context", blogDO.getContext());
        }
        if (StringUtils.isNotBlank(blogDO.getSummaryImg())) {
            updateWrapper.set("summaryImg", blogDO.getSummaryImg());
        }
        if (StringUtils.isNotBlank(blogDO.getContextImg())) {
            updateWrapper.set("contextImg", blogDO.getContextImg());
        }
        if (blogDO.getType() != 0) {
            updateWrapper.set("type", blogDO.getType());
        }
        if (blogDO.getBlogType() != null) {
            updateWrapper.set("blogType", blogDO.getBlogType());
        }
        if (blogDO.getCreateTime() != null) {
            updateWrapper.set("createTime", blogDO.getCreateTime());
        }
        if (blogDO.getViewCount() != 0) {
            updateWrapper.set("viewCount", blogDO.getViewCount());
        }
        if (blogDO.getCommentCount() != 0) {
            updateWrapper.set("commentCount", blogDO.getCommentCount());
        }
        return blogDAO.update(blogDO, updateWrapper);
    }

    /**
     * 删除一条博客信息，只需要博客id
     */
    public Integer deleteBlog(BlogDO blogDO) {
        return blogDAO.deleteById(blogDO.getId());
    }

    /**
     * 查询所有的博客字段，按照创建时间排序
     */
    public List<BlogDO> findAllBlog(int begin, int rows) {
        QueryWrapper<BlogDO> queryWrapper = new QueryWrapper<BlogDO>()
                .orderByDesc("createTime")
                .last("limit " + begin + "," + rows);
        return blogDAO.selectList(queryWrapper);
    }

    /**
     * 根据博客id找到对应的博客
     */
    public BlogDO findBlogById(Long id) {
        return blogDAO.selectById(id);
    }

    /**
     * 计算数据库一共有多少数据
     */
    public Long countListSize() {
        return blogDAO.selectCount(null);
    }

    /**
     * 增加点击率
     */
    public void viewBlog(Long id) {
        UpdateWrapper<BlogDO> updateWrapper = new UpdateWrapper<BlogDO>().eq("id", id).setSql("viewCount = viewCount+1");
        blogDAO.update(null, updateWrapper);
    }

}
