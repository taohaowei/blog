package mapper;

import model.BlogContext;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by TaoHaoWei on 2018/5/20.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
@Mapper
@Repository("blogContextMapper")
public interface BlogContextMapper {

    @Select("SELECT context FROM t_blogContext_00 WHERE id=#{id}")
    String getContextByBlogId(Integer id);

    @Insert("INSERT INTO t_blogContext_00(id, context) values(#{id}, #{context})")
    int insert(BlogContext blogContext);
}
