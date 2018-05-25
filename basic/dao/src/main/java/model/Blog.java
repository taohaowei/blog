package model;

import java.util.Date;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客文章的实体类
 */
public class Blog {
    /**
     * 博客id，主键、索引、自增
     */
    private int                         id;
    /**
     * 博客标题
     */
    private String                      title;
    /**
     * 博客摘要
     */
    private String                      summary;
    /**
     * 博客创建时间
     */
    private Date                        createTime;
    /**
     * 博客类型，1原创、2转载、3翻译，4收藏
     */
    private int                         type;
    /**
     * 博客 文章分类
     */
    private String                      blogType;
    /**
     * 阅读量
     */
    private int                         viewCount;
    /**
     * 评论量
     */
    private int                         commentCount;
    /**
     * 文章内容
     */
    private String                      context;
    /**
     * 博客摘要图片
     */
    private String                      summaryImg;
    /**
     * 博客内容图片
     */
    private String                      contextImg;

    public Blog() {
    }

    public Blog(String title, String summary, Date createTime, int type, String blogType, int viewCount, int commentCount, String context) {
        this.title = title;
        this.summary = summary;
        this.createTime = createTime;
        this.type = type;
        this.blogType = blogType;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.context = context;
    }

    public Blog(String title, String summary, Date createTime, int type, String blogType, int viewCount, int commentCount, String context, String summaryImg, String contextImg) {
        this.title = title;
        this.summary = summary;
        this.createTime = createTime;
        this.type = type;
        this.blogType = blogType;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.context = context;
        this.summaryImg = summaryImg;
        this.contextImg = contextImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getString() {
        return blogType;
    }

    public void setString(String blogType) {
        this.blogType = blogType;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSummaryImg() {
        return summaryImg;
    }

    public void setSummaryImg(String summaryImg) {
        this.summaryImg = summaryImg;
    }

    public String getContextImg() {
        return contextImg;
    }

    public void setContextImg(String contextImg) {
        this.contextImg = contextImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        if (id != blog.id) return false;
        if (type != blog.type) return false;
        if (viewCount != blog.viewCount) return false;
        if (commentCount != blog.commentCount) return false;
        if (title != null ? !title.equals(blog.title) : blog.title != null) return false;
        if (summary != null ? !summary.equals(blog.summary) : blog.summary != null) return false;
        if (createTime != null ? !createTime.equals(blog.createTime) : blog.createTime != null) return false;
        if (blogType != null ? !blogType.equals(blog.blogType) : blog.blogType != null) return false;
        if (context != null ? !context.equals(blog.context) : blog.context != null) return false;
        if (summaryImg != null ? !summaryImg.equals(blog.summaryImg) : blog.summaryImg != null) return false;
        return contextImg != null ? contextImg.equals(blog.contextImg) : blog.contextImg == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (blogType != null ? blogType.hashCode() : 0);
        result = 31 * result + viewCount;
        result = 31 * result + commentCount;
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (summaryImg != null ? summaryImg.hashCode() : 0);
        result = 31 * result + (contextImg != null ? contextImg.hashCode() : 0);
        return result;
    }
}
