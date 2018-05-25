package mapper;

import model.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客mapper接口类
 */
@Repository("blogMapper")
public interface BlogMapper {
    /**
     * 插入一条博客信息，除id外，每个字段必须存在。
     * @param blog
     * @return
     */
    int insertBlog(Blog blog);

    /**
     * @return 下一条插入的博客Id
     */
    @Select("Select max(id)+1 from t_blog_00")
    int getNextBlogId();

    /**
     * 更新一条博客信息，不为空字段，更新。id必须存在
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 删除一条博客信息，只需要博客id
     * @param blog
     * @return
     */
    int deleteBlog(Blog blog);

    /**
     * 查询所有的博客字段，按照创建时间排序
     * @return
     * @param begin
     * @param rows
     */
    List<Blog> findAllBlog(@Param("begin") int begin, @Param("rows") int rows);

    /**
     * 根据博客id找到对应的博客
     * @param id
     * @return
     */
    Blog findBlogById(int id);

    /**
     * 计算数据库一共有多少数据
     * @return
     */
    int countListSize();

    /**
     * 根据id寻找下一个博客内容
     * @param id
     * @return
     */
    Blog findNextBlogById(int id);

    /**
     * 增加点击率
     * @param id
     */
    void viewBlog(int id);
}
