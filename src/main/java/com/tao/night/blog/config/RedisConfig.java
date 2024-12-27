package com.tao.night.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName("localhost"); // Redis 服务器地址
//        configuration.setPort(6379);            // Redis 端口
//        configuration.setPassword("");         // 如果 Redis 设置了密码，填写密码
//        configuration.setDatabase(0);          // 使用的数据库索引（默认为 0）
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration);

        // 配置 Redis 连接工厂
        LettuceConnectionFactory factory = new LettuceConnectionFactory();
        // 设置其他属性
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 配置 RedisTemplate
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer()); // Hash 的 Key 序列化器
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer()); // Hash 的 Value 序列化器
        return template;
    }
}
