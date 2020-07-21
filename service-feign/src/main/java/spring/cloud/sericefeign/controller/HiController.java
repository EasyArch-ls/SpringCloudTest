package spring.cloud.sericefeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.sericefeign.service.ScheduleServiceHi;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午11:11
 * @Description:
 ***/
@RestController
public class HiController {
    @Autowired
    ScheduleServiceHi serviceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return serviceHi.sayHiFromClientOne(name);
    }
}
