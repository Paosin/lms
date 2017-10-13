package com.octave.controller.order;

import com.octave.entity.Address;
import com.octave.entity.PostOrder;
import com.octave.entity.User;
import com.octave.service.order.PostOrderService;
import com.octave.service.user.AddressService;
import com.octave.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@Controller
public class OrderController {

    @Autowired
    private PostOrderService postOrderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public String saveOrder(HttpSession session, PostOrder postOrder) {
        Boolean orderFlag = this.postOrderService.save(postOrder);
        Boolean addrFlag = true;
        User user = (User) session.getAttribute("user");
        if (orderFlag && null != user) {
            Address address = new Address();
            address.setAddress(postOrder.getAddr());
            address.setDetialAddress(postOrder.getAddrDetail());
            address.setUserId(user.getUserId());
            addrFlag = this.addressService.save(address);
        }
        if (orderFlag && addrFlag) {
            return "order_success";
        }
        return "order_error";
    }

    /**
     * 通过用户id获取用户的所有订单
     *
     * @param uid
     * @return
     */
    @GetMapping("/orders")
    public ModelAndView listOrder(Integer uid) {

        List<PostOrder> rs = this.postOrderService.listByUserId(uid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders", rs);
        mav.setViewName("order_list");
        return mav;
    }

    /**
     * 通过用户电话获取所有订单
     *
     * @param tel
     * @return
     */
    @GetMapping("/orders/tel")
    public @ResponseBody
    List<PostOrder> listOrderByTel(String tel) {
        System.out.println(tel);
        if (null != tel && !tel.isEmpty())
            return this.postOrderService.listByTel(tel);
        return null;
    }

    /**
     * 通过id数组获取对应的所有订单
     *
     * @param ids
     * @return
     */
    @GetMapping("/orders/ids")
    public @ResponseBody
    List<PostOrder> listOrderByIds(Integer[] ids) {
        Integer[] temp = null;
        if (ids.length > 20) {
            temp = new Integer[20];
            System.arraycopy(ids, 0, temp, 0, 20);
        }
        List<PostOrder> rs;
        if (temp != null) {
            rs = this.postOrderService.listByIds(temp);
        } else {
            rs = this.postOrderService.listByIds(ids);
        }
        return rs;
    }

}
