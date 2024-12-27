package com.tao.night.blog.dao.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by Taohaowei on 2017/8/8.
 */
@Data
@TableName("t_viewlog")
public class ViewLogDO {

    @TableId
    private Long id;

    private String ipAddress;

    private String ipMsg;

    private String requestURL;

    private String params;

    private String sessionId;

    private Date viewTime;

    private Integer visitor;

    private Long spendTime;

    public ViewLogDO() {
    }

    public ViewLogDO(String ipAddress, String requestURL, String params, String sessionId, Date viewTime, int visitor) {
        this.ipAddress = ipAddress;
        this.requestURL = requestURL;
        this.params = params;
        this.sessionId = sessionId;
        this.viewTime = viewTime;
        this.visitor = visitor;
    }
}
