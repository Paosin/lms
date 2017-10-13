package com.octave.service.order.impl;

import com.octave.entity.PostOrder;
import com.octave.service.order.PostOrderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostPostOrderServiceImplTest {

    @Autowired
    private PostOrderService postOrderService;

    @Test
    public void save() throws Exception {
        PostOrder postOrder = new PostOrder();
        postOrder.setName("orderName");
        postOrder.setAddr(358);
        postOrder.setAddrDetail("who knows");
        postOrder.setUserId(1);
        postOrder.setDate(new Date(System.currentTimeMillis()));
        postOrder.setContent("kill you");
        postOrder.setPhone("15608185191");
        postOrder.setPickupPhone("15289738368");
        postOrder.setWeightRange(1);
        if (!this.postOrderService.save(postOrder)) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    @Test
    public void listByUserId() throws Exception {
        for (PostOrder postOrder : this.postOrderService.listByUserId(1)) {
            System.out.println(postOrder);
        }
    }

}