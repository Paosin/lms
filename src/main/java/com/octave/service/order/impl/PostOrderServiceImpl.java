package com.octave.service.order.impl;

import com.octave.entity.PostOrder;
import com.octave.mapper.OrderMapper;
import com.octave.service.order.PostOrderService;
import com.octave.util.regex.CheckRegEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@Service
@Transactional(readOnly = true)
public class PostOrderServiceImpl implements PostOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean save(PostOrder postOrder) {
        /**
         * 注解判断为空
         */
        if (!CheckRegEx.check(postOrder)) {
            return false;
        }
        /**
         * 保证至少有一个电话不为空
         */
        if (StringUtils.isEmpty(postOrder.getTel()) && StringUtils.isEmpty(postOrder.getPhone()))
            return false;

        /**
         * 保证收件人至少有一个电话不
         */
        if (StringUtils.isEmpty(postOrder.getPickupTel()) && StringUtils.isEmpty(postOrder.getPickupPhone()))
            return false;

        return this.orderMapper.insert(postOrder) > 0;
    }

    @Override
    public List<PostOrder> listByUserId(Integer uid) {
        return this.orderMapper.listByUserId(uid);
    }

    @Override
    public List<PostOrder> listByIds(Integer[] ids) {
        if (ids.length > 1) {
            return this.orderMapper.listByIds(ids);
        }
        List<PostOrder> rs = new ArrayList<>();
        rs.add(this.orderMapper.selectByPrimaryKey(ids[0]));
        return rs;
    }

    @Override
    public List<PostOrder> listByTel(String tel) {
        return this.orderMapper.listByTel(tel);
    }

}
