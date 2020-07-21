package springcloud.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午10:54
 * @Description:
 ***/
@Service
public class HiService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name){
        return  restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
