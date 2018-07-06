package com.sprinboot.demo.controller;

import com.sprinboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    HttpServletRequest httpServletRequest;

    @PostMapping("/testHttpClientPost")
    @ResponseBody
    public Object testHttpClientPost(@RequestHeader HttpHeaders headers) {

        Map<String, Object> hashmap = getStringStringMap(headers);
        return hashmap;
    }


    @GetMapping("/testHttpclientGet")
    @ResponseBody
    public Object testHttpclientGet(@RequestHeader HttpHeaders headers) {

        Map<String, Object> hashmap = getStringStringMap(headers);
        return hashmap;
    }

    private Map<String, Object> getStringStringMap(@RequestHeader HttpHeaders headers) {
        System.out.println(headers.toSingleValueMap());

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey());
            System.out.println(Arrays.toString(stringEntry.getValue()));
        }

        Map<String, Object> hashmap = new HashMap<>();
        hashmap.put("code", "success");
        hashmap.put("name", "zhao");
        hashmap.put("age", new User(1,"li",new Date()));
        return hashmap;
    }
}
