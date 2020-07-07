package com.alsa.mvc.uriLink.uriBuilder;

import com.alsa.mvc.handlerMethods.jaksonJson.User;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 10:06
 * @Description:
 */
public class UriBuilderTest {

    @Test
    public void testUriBuilderWithRestTemplate(){
        String baseUrl = "http://localhost";
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(factory);
        User user = restTemplate.getForObject("/user", User.class);
        System.out.println(user);
    }

}
