package com.octave.util.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailUtilsTest {

    @Autowired
    EmailUtils emailUtils;

    @Test
    public void sendSimpleMail() throws Exception {
        emailUtils.sendSimpleMail("630052986@qq.com","什么玩意","sdlfkjsdlfjklkdsjlsdkjflkj");
    }

}