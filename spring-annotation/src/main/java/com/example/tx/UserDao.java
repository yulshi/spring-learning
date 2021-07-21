package com.example.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author yulshi
 * @create 2020/06/04 21:32
 */
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert() {

        String sql = "insert into temperatures(sensor,temperature) values(? ,?)";
        jdbcTemplate.update(sql, "sensor-7", 100.0);

    }

}
