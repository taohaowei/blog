package com.tao.night.blog.service;

import com.tao.night.blog.config.RedisHelper;
import com.tao.night.blog.dao.impl.BlogAdapter;
import com.tao.night.blog.dao.model.BlogDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 */
@Service("blogService")
public class BlogService {

    private final Logger logger = LoggerFactory.getLogger("blog");

    @Autowired
    private BlogAdapter blogAdapter;

    @Autowired
    private RedisHelper redisHelper;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Long insert(BlogDO blogDO, String contextFilePath) {
        //从blog.html中获取博客内容
        String context = fileToString(contextFilePath);
        //设置博客内容属性
        blogDO.setContext(context);
        logger.debug("insert()方法：blogDO = " + blogDO);
        //从jedis中获取当前最大博客id，并设置博客id
        Long blogId = redisHelper.blogId(1);
        logger.debug("insert()： blogId= " + blogId);
        blogDO.setId(blogId);
        //设置博客其他属性
        blogDO.setCreateTime(new Date());
        blogDO.setSummaryImg(redisHelper.summaryImg());
        int result = blogAdapter.insertBlog(blogDO);
        if (result > 0) {
            return blogId;
        } else {
            return 0L;
        }
    }

    public BlogDO findBlogById(int id) {
        //查询这个的时候增加点击数
        blogAdapter.viewBlog(id);
        return blogAdapter.findBlogById(id);
    }

    public BlogDO findNextBlogById(int id) {
        return blogAdapter.findBlogById(id);
    }


    public int update(BlogDO blogDO) {
        return blogAdapter.updateBlog(blogDO);
    }

    public int delete(BlogDO blogDO) {
        return blogAdapter.deleteBlog(blogDO);
    }

    public List<BlogDO> findAllBlog(int begin, int rows) {
        return blogAdapter.findAllBlog(begin, rows);
    }

    public Long countListSize() {
        return blogAdapter.countListSize();
    }

    private String fileToString(String filePath) {
        StringBuffer sb = new StringBuffer();

        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("fileToString()方法：内容文件不存在");
            return "";
        }
        Date date = new Date(file.lastModified());
        logger.debug("fileToString()方法：filePath = " + filePath);
        logger.debug("fileToString()方法：date = " + sdf.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        logger.debug("fileToString()方法：calendar.getTime() = " + sdf.format(calendar.getTime()));

        if (calendar.getTime().after(date))//如果文件最后更新时间在昨天之前，报错
        {
            logger.error("fileToString()方法：内容文件过旧");
            return "";
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String src;
            while ((src = br.readLine()) != null) {
                sb.append(src);
            }
        } catch (FileNotFoundException e) {
            logger.error("fileToString()方法：内容文件不存在");
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            logger.error("fileToString()方法：读取过程出错");
            e.printStackTrace();
            return "";
        }

        String context = sb.substring(sb.indexOf("<body>"), sb.indexOf("</body>"));

        return context;
    }
}
