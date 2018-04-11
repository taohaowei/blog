package com.tao.Factory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Taohaowei on 2017/8/2.
 */
public class JedisFactory {
    private static String redisAddress = "47.94.107.115";
    private static int redisPort = 6379;
    private static int redisTimeout = 2000;
    //配置连接池，连接对象，其中jedisPoolConfig对象可以操控连接的空闲时间、连接个数等等，这里采用默认方式
    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), redisAddress, redisPort, redisTimeout);

    private static Jedis jedis = null;
    private static Transaction tx = null;//事务


    private static Jedis getJedisConnect()
    {
        jedis = pool.getResource();
        return jedis;
    }

    static {
        getJedisConnect();
    }

    private static Transaction getTransaction()
    {
        tx = getJedisConnect().multi();
        return tx;
    }

    private static void close(Jedis jedis, Transaction tx)
    {
        if (jedis != null)
            jedis.close();
        if (pool != null)
            pool.close();
    }


    /**
     *
     * @param inc 传入值叠加
     * @return 返回当前最大的id
     */
    public static int blogId(int inc){
        int blogId = Integer.valueOf(jedis.get("blogId"));
        jedis.set("blogId",String.valueOf(blogId+inc));
        return blogId;
    }

    public static String summaryImg(){
        StringBuffer summaryImg = new StringBuffer();
        summaryImg.append("project-");
        int summaryId = Integer.valueOf(jedis.get("summaryId"));

        if(summaryId==8)
        {
            jedis.set("summaryId","0");
        }else{
            jedis.incr("summaryId");
        }
        summaryImg.append(summaryId+".jpg");
        return summaryImg.toString();
    }

    private static String contextImg(int inc){
        StringBuffer contextImg = new StringBuffer();
        int blogId = Integer.valueOf(jedis.get("blogId"));
        jedis.set("blogId",String.valueOf(blogId+inc));

        return contextImg.toString();
    }


}
