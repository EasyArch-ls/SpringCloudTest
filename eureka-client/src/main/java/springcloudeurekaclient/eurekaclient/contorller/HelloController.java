package springcloudeurekaclient.eurekaclient.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author: lisheng
 * @Date: 2020/7/21
 * @Time: 上午10:45
 * @Description:
 ***/
@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
        return "name:" + "\t" + name + "\t" + "port:" + "\t" + port;
    }
}
