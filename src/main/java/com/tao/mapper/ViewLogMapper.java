package com.tao.mapper;

import com.tao.model.ViewLog;

import java.util.ArrayList;

/**
 * Created by Taohaowei on 2017/8/8.
 */
public interface ViewLogMapper {
    public ViewLog findViewLogByIp(String remoteAddr);
    public ArrayList<ViewLog> findAllViewLogByIp(String remoteAddr);
    public ArrayList<ViewLog> findAllViewLog();

    public void insertViewLog(ViewLog viewLog);

    /**
     * 查找未被处理的ip信息
     * @return
     */
    public ArrayList<ViewLog> findNeedBeUpdateIp();

    /**
     * 更新未被处理的ip信息
     */
    public void updateIpMsg(ViewLog viewLog);
}
