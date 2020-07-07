package com.alsa.mvc.uriLink.relativeServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 14:01
 * @Description:
 */
@Controller
public class RelativeServletRequestController {

    @RequestMapping("/relativeServlet")
    @ResponseBody
    public String getString(HttpServletRequest request){
        UriComponents ucb = ServletUriComponentsBuilder.fromRequest(request)
                .replaceQueryParam("accountId","{id}").build()
                .expand("123")
                .encode();
        System.out.println(ucb);//http://localhost/relativeServlet?accountId=123
        return "longming";

    }
}
