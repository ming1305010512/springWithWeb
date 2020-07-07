package com.alsa.mvc.uriLink.LinksToControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 14:38
 * @Description:
 */
@Controller
@RequestMapping("/hotels/{hotel}")
public class BookingController {

    @GetMapping("/bookings/{booking}")
    public ModelAndView getBooking(@PathVariable Long booking){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("longming","你好");
        System.out.println("booking为："+booking);
        return modelAndView;
    }
}
