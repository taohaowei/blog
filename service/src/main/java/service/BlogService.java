package service;

import mapper.BlogContextMapper;
import model.BlogContext;
import org.springframework.transaction.annotation.Transactional;
import redis.JedisFactory;
import mapper.BlogMapper;
import model.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import util.BlogUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 */
@Service("blogService")
public class BlogService{

    private Logger logger = LoggerFactory.getLogger(BlogService.class);

    @Autowired
    @Qualifier("blogMapper")
    private BlogMapper blogMapper;
    @Autowired
    @Qualifier("blogContextMapper")
    private BlogContextMapper blogContextMapper;

    /**
     * 事务完成，插入博客
     * 1、将博客文章存储，向数据库中插入不保存context的数据（优化数据库查询）
     * 废弃 2、把博客文章内容以文件形式存储到/blog/*.html
     * 2、把博客文章存入新的表中
     * @param blog
     * @param path
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insert(Blog blog,String path) throws IOException {
        //设置博客内容属性
        logger.info("insert()方法：blog = "+blog);
        //从jedis中获取当前最大博客id，并设置博客id
        String blogId = JedisFactory.blogId();
        if(blogId == null)
        {
            blogId = String.valueOf(blogMapper.getNextBlogId());
            JedisFactory.set("blogId",blogId+1);
        }

        logger.info("insert()： blogId= "+blogId);
        blog.setId(Integer.valueOf(blogId));
        //设置博客其他属性
        blog.setCreateTime(new Date());
        blog.setSummaryImg(JedisFactory.summaryImg());
        //更改存入数据库内的博客内容
        String context = blog.getContext();
        blog.setContext(blogId+".html");

        //插入数据以及存储文件
        int result = blogMapper.insertBlog(blog);
        result += blogContextMapper.insert(new BlogContext(blog.getId(), context));
//        BlogUtil.strSaveToFile(context, path+blog.getContext());

        if(result>1)
        {
            return Integer.valueOf(blogId);
        }else{
            return 0;
        }
    }

    public Blog findBlogById(int id)
    {
        logger.info("findBlogById("+id+")");
        //查询这个的时候增加点击数
        blogMapper.viewBlog(id);
        String contextByBlogId = blogContextMapper.getContextByBlogId(id);
        Blog blogById = blogMapper.findBlogById(id);
        blogById.setContext(contextByBlogId);
        return blogById;
    }
    public Blog findNextBlogById(int id)
    {
        return blogMapper.findNextBlogById(id);
    }


    public int update(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    public int delete(Blog blog) {
        return blogMapper.deleteBlog(blog);
    }

    public List<Blog> findAllBlog(int begin, int rows) {
        return blogMapper.findAllBlog(begin,rows);
    }

    public int countListSize(){return  blogMapper.countListSize();}


}
