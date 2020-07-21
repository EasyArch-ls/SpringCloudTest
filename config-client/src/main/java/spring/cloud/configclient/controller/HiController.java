package spring.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 下午2:26
 * @Description:
 ***/
@RestController
public class HiController {
    @Value("${foo}")
    String foo;
    @Value("${democonfigclient.message}")
    String message;

    @RequestMapping(value = "hi")
    public String hi() {
        return foo;
    }

    @RequestMapping(value = "message")
    public String message() {
        return message;
    }
}
