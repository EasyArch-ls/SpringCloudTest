package springcloudeurekaclient.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * Demo class
 *
 * @author ls
 * @date 20-7-21
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String Hi(@RequestParam("name")String name){
        return "name:"+"\t"+name+"\t"+"port:"+"\t"+port;
    }
}
