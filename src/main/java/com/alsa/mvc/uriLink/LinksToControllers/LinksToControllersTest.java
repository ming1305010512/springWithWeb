package com.alsa.mvc.uriLink.LinksToControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 15:25
 * @Description:
 */
@Controller
public class LinksToControllersTest {
    @RequestMapping("/linksToController")
    @ResponseBody
    public String testLinksToControllers(){
        UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(BookingController.class,"getBooking",21L).buildAndExpand(42);
        URI uri = uriComponents.encode().toUri();
        System.out.println(uri);//http://localhost/hotels/42/bookings/21

        //如果在请求上下文外部或者插入一个路径前缀，可以使用这种方式
        UriComponentsBuilder base = ServletUriComponentsBuilder.fromCurrentContextPath().path("/en");
        MvcUriComponentsBuilder builder = MvcUriComponentsBuilder.relativeTo(base);
        UriComponents componentsBuilder = builder.withMethodCall(on(BookingController.class).getBooking(21L)).buildAndExpand(42);

        URI uri1 = componentsBuilder.toUri();
        System.out.println(uri1);//http://localhost/en/hotels/42/bookings/21
        return uri.toString();
    }
}
