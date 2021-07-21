package com.example;

import com.example.tx.TxConfig;
import com.example.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yulshi
 * @create 2020/06/04 21:39
 */
public class TestTransaction {

    @Test
    public void testTx() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.insertTemp();

        context.close();

    }

}
