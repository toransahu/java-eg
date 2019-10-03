package com.eg.examples.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

import java.util.concurrent.TimeUnit;


public class RedisBrokenConnectionEx {
    JedisPool pool;

    RedisBrokenConnectionEx() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // YH, this??
        // jedisPoolConfig.setMinEvictableIdleTimeMillis(TimeUnit.SECONDS.toMillis(6)); 
        pool = new JedisPool(jedisPoolConfig, "localhost");
    }

    void Run() {
        System.out.println("Starting...");
        // Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        try (Jedis jedis = pool.getResource()) {
            // do stuff
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            System.out.println(foobar);
            System.out.println(jedis.configGet("timeout"));
            System.out.println(jedis.configGet("tcp-keepalive"));
        } catch (JedisException e) {
            System.out.println(e);
        }
    }

    void Exit() {
        // when closing your application:r
        System.out.println("Done!");
        pool.close();
    }

    public static void main(String[] args) throws InterruptedException {
        RedisBrokenConnectionEx r = new RedisBrokenConnectionEx();
        for (int i = 0; i < 1; i++) {
            r.Run();
        }
        System.out.println("Sleep Start.");
        TimeUnit.SECONDS.sleep(120);
        System.out.println("Sleep End.");
        for (int i = 0; i < 1; i++) {
            r.Run();
        }
        r.Exit();
    }
}
