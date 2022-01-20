package com.yjlan.im.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjlan
 * @version V1.0
 * @Description 测试Controller
 * @date 2022.01.20 15:39
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    
    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
