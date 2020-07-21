package springcloud.serviceribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.serviceribbon.service.HiService;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午10:56
 * @Description:
 ***/
@RestController
public class HiController {
    @Autowired
    HiService hiservice;

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
        return hiservice.hiService(name);
    }

    public String hiError(String name) {
        return "hi" + "\t" + name + "sorry error";
    }
}
