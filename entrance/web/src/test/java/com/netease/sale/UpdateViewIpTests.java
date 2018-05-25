package com.netease.sale;

import mapper.ViewLogMapper;
import model.ViewLog;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.UpdateViewIp;

import java.util.ArrayList;

/**
 * Created by TaoHaoWei on 2018/5/19.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
public class UpdateViewIpTests {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Web.xml");
        ViewLogMapper viewLogMapper = (ViewLogMapper) context.getBean("viewLogMapper");
        ArrayList<ViewLog> needBeUpdateIp = viewLogMapper.findNeedBeUpdateIp();
        for (ViewLog viewLog : needBeUpdateIp)
        {
            System.out.println(viewLog);
            viewLog.setIpMsg(UpdateViewIp.GetJsonByIp(viewLog.getIpAddress()));
            viewLogMapper.updateIpMsg(viewLog);
        }
    }

}
