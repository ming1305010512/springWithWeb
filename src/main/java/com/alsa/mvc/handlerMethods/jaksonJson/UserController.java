package com.alsa.mvc.handlerMethods.jaksonJson;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/6
 * @Time: 15:39
 * @Description:
 */
@RestController
public class UserController {
    @GetMapping("/user")
    @JsonView(User.WithoutPasswordView.class)
    public User getUser() {
        return new User("eric", "7!jd#h23");
    }
}
