package com.tao.night.blog.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tao.night.blog.dao.ViewLogDAO;
import com.tao.night.blog.dao.model.ViewLogDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客mapper接口类
 */
@Component
public class ViewLogAdapter {

    @Autowired
    private ViewLogDAO viewLogDAO;

    public ViewLogDO findViewLogByIp(String remoteAddr) {
        QueryWrapper<ViewLogDO> queryWrapper = new QueryWrapper<ViewLogDO>()
                .eq("ipAddress", remoteAddr)
                .orderByDesc("viewTime")
                .last("limit 1");
        return viewLogDAO.selectOne(queryWrapper);
    }

    public List<ViewLogDO> findAllViewLogByIp(String remoteAddr) {
        QueryWrapper<ViewLogDO> queryWrapper = new QueryWrapper<ViewLogDO>()
                .eq("ipAddress", remoteAddr)
                .orderByDesc("viewTime");
        return viewLogDAO.selectList(queryWrapper);
    }

    public List<ViewLogDO> findAllViewLog() {
        return viewLogDAO.selectList(null);
    }

    public Integer insertViewLog(ViewLogDO viewLogDO) {
        return viewLogDAO.insert(viewLogDO);
    }

    /**
     * 查找未被处理的ip信息
     *
     * @return
     */
    public List<ViewLogDO> findNeedBeUpdateIp() {
//        SELECT id,ipAddress FROM t_viewlog_00 WHERE ipMsg is null;
        QueryWrapper<ViewLogDO> queryWrapper = new QueryWrapper<ViewLogDO>()
                .isNull("ipMsg");
        return viewLogDAO.selectList(queryWrapper);
    }

    /**
     * 更新未被处理的ip信息
     */
    public Integer updateIpMsg(ViewLogDO viewLogDO) {
//        UPDATE t_viewlog_00 SET ipMsg='${ipMsg}' WHERE id=#{id}

        UpdateWrapper<ViewLogDO> updateWrapper = new UpdateWrapper<ViewLogDO>().eq("id", viewLogDO.getId()).set("ipMsg", viewLogDO.getIpMsg());
        return viewLogDAO.update(viewLogDO, updateWrapper);
    }
}
