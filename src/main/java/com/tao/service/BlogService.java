package com.tao.service;

import com.tao.Factory.JedisFactory;
import com.tao.mapper.BlogMapper;
import com.tao.model.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class BlogService{

    private Logger logger = LoggerFactory.getLogger("blog");

    @Autowired
    @Qualifier("blogMapper")
    private BlogMapper blogMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public int insert(Blog blog,String contextFilePath) {
        //从blog.html中获取博客内容
        String context = fileToString(contextFilePath);
        //设置博客内容属性
        blog.setContext(context);
        logger.debug("insert()方法：blog = "+blog);
        //从jedis中获取当前最大博客id，并设置博客id
        int blogId = JedisFactory.blogId(1);
        logger.debug("insert()： blogId= "+blogId);
        blog.setId(blogId);
        //设置博客其他属性
        blog.setCreateTime(new Date());
        blog.setSummaryImg(JedisFactory.summaryImg());
        int result = blogMapper.insertBlog(blog);
        if(result>0)
        {
            return blogId;
        }else{
            return 0;
        }
    }

    public Blog findBlogById(int id)
    {
        //查询这个的时候增加点击数
        blogMapper.viewBlog(id);
        return blogMapper.findBlogById(id);
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

    private String fileToString(String filePath)
    {
        StringBuffer sb = new StringBuffer();

        File file = new File(filePath);
        if(!file.exists())
        {
            logger.error("fileToString()方法：内容文件不存在");
            return "";
        }
        Date date = new Date(file.lastModified());
        logger.debug("fileToString()方法：filePath = "+filePath);
        logger.debug("fileToString()方法：date = "+sdf.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE) - 1);
        logger.debug("fileToString()方法：calendar.getTime() = "+sdf.format(calendar.getTime()));

        if(calendar.getTime().after(date))//如果文件最后更新时间在昨天之前，报错
        {
            logger.error("fileToString()方法：内容文件过旧");
            return "";
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String src;
            while ((src=br.readLine())!=null)
            {
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

        String context = sb.substring(sb.indexOf("<body>"),sb.indexOf("</body>"));

        return context;
    }
}
