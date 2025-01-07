package com.tao.night.blog.interceptor;

import com.tao.night.blog.dao.impl.ViewLogAdapter;
import com.tao.night.blog.dao.model.ViewLogDO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * 拦截器：记录访问日志
 */
@Component
public class LoadInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger("access");

    @Autowired
    private ViewLogAdapter viewLogAdapter;

    private long beginTime;
    private ViewLogDO viewLogDO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置默认访客标识
        request.setAttribute("visiter", 0);

        // 根据 IP 查找访问记录
        ViewLogDO existingLog = viewLogAdapter.findViewLogByIp(request.getRemoteAddr());
        if (existingLog != null) {
            request.setAttribute("visiter", 1);
        } else {
            existingLog = new ViewLogDO();
        }

        // 构造新的访问日志对象
        viewLogDO = new ViewLogDO(
                request.getRemoteAddr(),
                request.getRequestURI(),
                getUrlParams(request.getParameterMap()),
                request.getRequestedSessionId(),
                new Date(),
                Optional.ofNullable(existingLog.getVisitor()).orElse(0) + 1
        );

        beginTime = System.currentTimeMillis();

        // 记录请求参数日志
        if (logger.isDebugEnabled()) {
            logger.debug("Request URI: {} Params: {}", request.getRequestURI(), getUrlParams(request.getParameterMap()));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long spendTime = System.currentTimeMillis() - beginTime;

        // 设置耗时并保存日志
        viewLogDO.setSpendTime(spendTime);
        viewLogAdapter.insertViewLog(viewLogDO);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 可以在这里处理清理逻辑（如果有）
    }

    /**
     * 将请求参数转换为字符串格式
     */
    private String getUrlParams(Map<String, String[]> parameterMap) {
        StringJoiner params = new StringJoiner(",", "{", "}");
        parameterMap.forEach((key, values) -> {
            StringJoiner valueJoiner = new StringJoiner(",", "[", "]");
            for (String value : values) {
                valueJoiner.add(value);
            }
            params.add("(" + key + " : " + valueJoiner + ")");
        });
        return params.toString();
    }
}
