package springcloudeurekaclient.eurekaclient.comment.group;

import java.lang.annotation.*;

/***
 * @Author: lisheng
 * @Date: 2020/7/23
 * @Time: 上午11:43
 * @Description:
 ***/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String name () default "";
}
