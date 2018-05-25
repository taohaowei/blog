package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by TaoHaoWei on 2018/5/14.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "job")
public class JobConfiguration {
    public JobConfiguration()
    {
        System.out.println("初始化JobConfiguration完成");
    }
}
