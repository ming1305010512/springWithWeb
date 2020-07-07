package com.alsa.mvc.uriLink.uriComponents;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 9:32
 * @Description:
 */
public class UriComponentsTest {

    @Test
    public void testUriComponents(){
        URI uri = UriComponentsBuilder.fromUriString("https://example.com///hotels/{hotel}")
                .queryParam("q","{q}")
                .encode()
                .buildAndExpand("Westin","123;abc.txt")
                .toUri();
        System.out.println(uri);
    }
}
