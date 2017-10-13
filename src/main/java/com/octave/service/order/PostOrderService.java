package com.octave.service.order;

import com.octave.entity.PostOrder;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
public interface PostOrderService {
    /**
     * 插入一条订单
     * @param postOrder
     * @return
     */
    Boolean save(PostOrder postOrder);

    List<PostOrder> listByUserId(Integer uid);

    /**
     * 通过id数组获取大量订单
     * @param ids
     * @return
     */
    List<PostOrder> listByIds(Integer[] ids);

    /**
     * 通过寄件方或收件方的手机号查询运单
     * @param tel
     * @return
     */
    List<PostOrder> listByTel(String tel);
}
