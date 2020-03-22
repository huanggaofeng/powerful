package com.hgf.controla;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlaApplicationTests {

    @Test
    public void contextLoads() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("hgf", key -> {
            System.out.println(key);
            return "hgf";
        });

    }

}
