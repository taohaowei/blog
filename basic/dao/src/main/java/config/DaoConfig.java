package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by TaoHaoWei on 2018/5/10.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
@Configuration
@ImportResource(locations = "classpath:applicationContext-dao.xml")
public class DaoConfig {

    public DaoConfig()
    {
        System.out.println("DaoConfig 初始化完成...");
    }
}
