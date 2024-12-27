package com.tao.night.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Taohaowei on 2017/8/2.
 */
@Component
public class RedisHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * @param inc 传入值叠加
     * @return 返回当前最大的id
     */
    public Long blogId(int inc) {
        Long blogId = Long.parseLong(Optional.ofNullable(redisTemplate.opsForValue().get("blogId")).map(Object::toString).orElse("0"));
        redisTemplate.opsForValue().set("blogId", String.valueOf(blogId + inc));
        return blogId;
    }

    public String summaryImg() {
        StringBuffer summaryImg = new StringBuffer();
        summaryImg.append("project-");
        int summaryId = Integer.parseInt(Optional.ofNullable(redisTemplate.opsForValue().get("summaryId")).map(Object::toString).orElse("0"));

        if (summaryId == 8) {
            redisTemplate.opsForValue().set("summaryId", 0);
        } else {
            redisTemplate.opsForValue().increment("summaryId");
        }
        summaryImg.append(summaryId).append(".jpg");
        return summaryImg.toString();
    }

}
