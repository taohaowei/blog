package model;

import java.util.Date;

/**
 * Created by Taohaowei on 2017/8/8.
 */
public class ViewLog {
    private int id;
    private String ipAddress;
    private String ipMsg;
    private String requestURL;
    private String params;
    private String sessionId;
    private Date viewTime;
    private int visiter;
    private long spendTime;

    public ViewLog() {
    }

    public ViewLog(String ipAddress, String requestURL, String params,String sessionId, Date viewTime, int visiter) {
        this.ipAddress = ipAddress;
        this.requestURL = requestURL;
        this.params = params;
        this.sessionId = sessionId;
        this.viewTime = viewTime;
        this.visiter = visiter;
    }

    public String getIpMsg() {
        return ipMsg;
    }

    public void setIpMsg(String ipMsg) {
        this.ipMsg = ipMsg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getUserToken() {
        return sessionId;
    }

    public void setUserToken(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public int getVisiter() {
        return visiter;
    }

    public void setVisiter(int visiter) {
        this.visiter = visiter;
    }

    public long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(long spendTime) {
        this.spendTime = spendTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ViewLog{" +
                "id='" + id + '\'' +
                "ipAddress='" + ipAddress + '\'' +
                ", requestURL='" + requestURL + '\'' +
                ", params=" + params +
                ", sessionId='" + sessionId + '\'' +
                ", viewTime=" + viewTime +
                ", visiter=" + visiter +
                ", spendTime=" + spendTime +
                '}';
    }
}
