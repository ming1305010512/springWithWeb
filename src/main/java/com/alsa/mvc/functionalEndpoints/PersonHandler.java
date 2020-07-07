package com.alsa.mvc.functionalEndpoints;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/6
 * @Time: 19:34
 * @Description:
 */
@Controller
public class PersonHandler {

    @RequestMapping("/person")
    public ServerResponse listPeople(){
        Person person = new Person();
        person.setId("1");
        person.setName("longming");
        person.setCode("A001");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(person);
    }
}
