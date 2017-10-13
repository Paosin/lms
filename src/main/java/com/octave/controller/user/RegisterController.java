package com.octave.controller.user;

import com.octave.entity.Client;
import com.octave.entity.User;
import com.octave.service.user.ClientService;
import com.octave.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Paosin Von Scarlet on 2017/10/11.
 */
@Controller
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }


    @GetMapping("/user")
    public String register(User user) {
        if (this.userService.save(user)) {
            return "redirect:home";
        }
        return "redirect:/api/register";
    }

    @PostMapping("/client")
    public String registerClient(Client client) {
        if (this.clientService.save(client)) {
            return "redirect:home";
        }
        return "redirect:/api/register";
    }
}
