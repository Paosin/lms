package com.octave.mapper;

import com.octave.entity.PostOrder;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderMapper")
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(PostOrder record);

    int insertSelective(PostOrder record);

    PostOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(PostOrder record);

    int updateByPrimaryKey(PostOrder record);

    /**
     * 通过用户id获取
     *
     * @param uid
     * @return
     */
    List<PostOrder> listByUserId(Integer uid);

    /**
     * 通过订单号数组获取
     *
     * @param ids
     * @return
     */
    List<PostOrder> listByIds(Integer[] ids);

    /**
     * 通过寄件方或收件方电话获取
     *
     * @param tel
     * @return
     */
    List<PostOrder> listByTel(String tel);
}