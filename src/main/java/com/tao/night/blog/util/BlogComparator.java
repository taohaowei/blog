package com.tao.night.blog.util;

import com.tao.night.blog.dao.model.BlogDO;

import java.util.Comparator;

/**
 * Created by Taohaowei on 2017/7/26.
 */
public class BlogComparator implements Comparator<BlogDO> {

    @Override
    public int compare(BlogDO o1, BlogDO o2) {
        return (int)(o2.getId() - o1.getId());
    }
}
