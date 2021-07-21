package com.example.cache;

import com.example.cache.bean.Employee;
import com.example.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yulshi
 * @create 2020/06/06 14:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheMainTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void testEmployeeMapper() {
        Employee employee = employeeMapper.getEmployee(1);
        System.out.println(employee);
    }

    @Test
    public void testRedis() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
        Employee employee = employeeMapper.getEmployee(1);
        redisTemplate.opsForValue().set("emp-01", employee);
    }

}
