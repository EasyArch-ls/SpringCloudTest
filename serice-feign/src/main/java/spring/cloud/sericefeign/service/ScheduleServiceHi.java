package spring.cloud.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午11:09
 * @Description:
 ***/
@FeignClient(value = "service-hi")
public interface ScheduleServiceHi {
    /**
     * @param name 用户名
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
