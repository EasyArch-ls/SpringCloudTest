package spring.cloud.servicehizipkin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * @Author: lisheng
 * @Date: 2020/7/22
 * @Time: 下午3:21
 * @Description:
 ***/
@RestController
@Slf4j
public class HiController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "hi")
    public String hi() {
        log.info("calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        log.info("calling trace service-hi ");
        return "i'm service-hi";

    }
}
