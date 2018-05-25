package mapper;

import model.ViewLog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Taohaowei on 2017/8/8.
 */
public interface ViewLogMapper {
    ViewLog findViewLogByIp(String remoteAddr);
    ArrayList<ViewLog> findAllViewLogByIp(String remoteAddr);
    ArrayList<ViewLog> findAllViewLog();

    List<ViewLog> getRecentlyAttackViewLog(Date date);

    void insertViewLog(ViewLog viewLog);

    /**
     * 查找未被处理的ip信息
     * @return
     */
    ArrayList<ViewLog> findNeedBeUpdateIp();

    /**
     * 更新未被处理的ip信息
     */
    void updateIpMsg(ViewLog viewLog);


}
