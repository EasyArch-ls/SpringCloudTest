package spring.cloud.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.sericefeign.service.impl.ScheduleServiceHiImpl;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午11:09
 * @Description:
 ***/
@Service
//@FeignClient(value = "service-hi")
@FeignClient(value = "service-hi",fallback = ScheduleServiceHiImpl.class )
public interface ScheduleServiceHi {
    /**
     * @param name 用户名
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
