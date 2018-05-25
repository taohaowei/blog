package job;

import mapper.ViewLogMapper;
import model.ViewLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import util.BackUpDBUtil;
import util.UpdateViewIp;

import java.util.ArrayList;

/**
 * Created by TaoHaoWei on 2018/5/24.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 * 更新用户日志
 */
@Component
public class BlogViewLogJob {

        private Logger logger = LoggerFactory.getLogger(job.BlogBackupJob.class);

        @Autowired
        private ViewLogMapper viewLogMapper ;

        public BlogViewLogJob()
        {
            System.out.println("BlogViewLogJob() 初始化完成.");
        }

        @Scheduled(cron = "0 3 4 * * ? ")
        public void doJob()
        {
            logger.info("开始更新日志");

            ArrayList<ViewLog> needBeUpdateIp = viewLogMapper.findNeedBeUpdateIp();
            int i =0;
            for (ViewLog viewLog : needBeUpdateIp)
            {
                i++;
                if(viewLog.getId()==13965)
                {
                    continue;
                }
                System.out.println(viewLog);
                viewLog.setIpMsg(UpdateViewIp.GetJsonByIp(viewLog.getIpAddress()));
                viewLogMapper.updateIpMsg(viewLog);
                if(i>=2000)
                {
                    break;
                }
            }
            logger.info("结束更新日志");
        }
}
