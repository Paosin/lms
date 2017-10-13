package com.octave.controller.user;

import com.octave.entity.User;
import com.octave.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Paosin Von Scarlet on 2017/10/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String toLogin() {
        return "loginPage";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpSession session,User user, ModelAndView mav) {
        User u = this.userService.checkLogin(user.getUserName(), user.getPassword());
        if (u == null) {
            mav.addObject("msg", "账号或密码不正确");
            mav.setViewName("loginPage");
        } else {
            session.setAttribute("user", u);
            mav.setViewName("redirect:home");
        }
        return mav;
    }
}
