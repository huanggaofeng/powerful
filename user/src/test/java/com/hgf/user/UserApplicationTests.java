package com.hgf.user;

import com.hgf.user.emtity.User;
import com.hgf.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelect() {
        System.out.println(userService.getUserNameById(1));
    }

    @Test
    public void testSave() {
        userService.insertUserTra();
    }
}
