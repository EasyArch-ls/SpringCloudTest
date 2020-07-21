package spring.cloud.sericefeign.service.impl;

import org.springframework.stereotype.Component;
import spring.cloud.sericefeign.service.ScheduleServiceHi;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午11:50
 * @Description:
 ***/
@Component
public class ScheduleServiceHiImpl implements ScheduleServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "name:"+ name+"\t sorry error";
    }
}
