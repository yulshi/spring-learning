package com.example.cache;

import com.example.cache.bean.Employee;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.nio.ByteBuffer;

/**
 * @author yulshi
 * @create 2020/06/06 14:13
 */
@SpringBootApplication
@MapperScan("com.example.cache.mapper")
@EnableCaching
public class CacheMain {

  public static void main(String[] args) {
    SpringApplication.run(CacheMain.class, args);
  }

  @Bean
  RedisTemplate<Object, Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Employee> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
    return template;
  }

  @Bean
  RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
    config = config.serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(
                    new Jackson2JsonRedisSerializer<Employee>(Employee.class)
            )
    );
    RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(config)
            .build();
    return cacheManager;

  }

}
