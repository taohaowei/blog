package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by TaoHaoWei on 2018/5/14.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
@Configuration
@ImportResource({
        "classpath:applicationContext-web.xml"

})
@PropertySource(value = {"classpath:application.yml"},encoding = "utf-8")
public class WebConfiguration {
    public WebConfiguration()
    {
        System.out.println("WebConfiguration()初始化完成.");
    }
}
