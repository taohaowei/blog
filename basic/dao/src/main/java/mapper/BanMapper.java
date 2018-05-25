package mapper;

import model.Ban;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by TaoHaoWei on 2018/5/20.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
@Repository("banMapper")
@Mapper
public interface BanMapper {
    @Select("select * from t_ban_00 where ip=#{ip} and ban=1")
    Ban isBan(String ip);

    @Insert("insert into t_ban_00 (ip) values(#{ip})")
    int insertBanIp(String ip);

}
