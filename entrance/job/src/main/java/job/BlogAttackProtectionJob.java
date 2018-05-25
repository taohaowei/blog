package job;

import mapper.BanMapper;
import mapper.ViewLogMapper;
import model.ViewLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import util.UpdateViewIp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by TaoHaoWei on 2018/5/24.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 * 博客攻击防护Job
 */
@Component
public class BlogAttackProtectionJob {
    private Logger logger = LoggerFactory.getLogger(job.BlogBackupJob.class);

    @Autowired
    private ViewLogMapper viewLogMapper ;
    private BanMapper banMapper;

    public BlogAttackProtectionJob()
    {
        System.out.println("BlogAttackProtectionJob() 初始化完成.");
    }


    /**
     * 博客攻击防护Job,每间隔时间段内统计一次.
     * 如果五分钟内，某个Ip的无效访问次数超过指定阕值，判定该Ip为恶意访问
     * 将其加入禁止Ip
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void doJob()
    {
        logger.info("开始日志分析处理");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, -5);
        List<ViewLog> recentlyAttackViewLog = viewLogMapper.getRecentlyAttackViewLog(instance.getTime());
        if(recentlyAttackViewLog != null && !recentlyAttackViewLog.isEmpty())
        {
            for (ViewLog viewLog : recentlyAttackViewLog) {
                banMapper.insertBanIp(viewLog.getIpAddress());
            }
        }
        logger.info("结束日志分析处理");
    }
}
