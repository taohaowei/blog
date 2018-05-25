package job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import util.BackUpDBUtil;

/**
 * Created by TaoHaoWei on 2018/5/24.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 * 用作备份数据库用的
 */
@Component
public class BlogBackupJob {

    private Logger logger = LoggerFactory.getLogger(BlogBackupJob.class);

    public BlogBackupJob()
    {
        System.out.println("BlogBackupJob() 初始化完成.");
    }

    @Scheduled(cron = "0 0 0 1/7 * ? ")
    public void doJob()
    {
        logger.info("开始备份");
        BackUpDBUtil.backup();
        logger.info("备份完毕");
    }
}
