package springcloudeurekaclient.eurekaclient.comment.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import springcloudeurekaclient.eurekaclient.comment.group.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;

/***
 * @Author: lisheng
 * @Date: 2020/7/23
 * @Time: 上午11:44
 * @Description:
 ***/
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut(value = "@annotation(springcloudeurekaclient.eurekaclient.comment.group.Log)")
    public void pointCut() {
    }
    @Around(value = "pointCut()")
    public Object logTest(ProceedingJoinPoint pjp){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println(request.getRequestURI());
        //拿到参数列表
        Object[] args = Arrays.stream(pjp.getArgs()).filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof MultipartFile) && !(arg instanceof HttpServletResponse))).toArray();
        System.out.println(JSON.toJSONString(args));
        System.out.println(request);
        System.out.println("-----------------------");
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //拿到所有的方法名
        System.out.println(JSON.toJSONString(signature.getParameterNames()));
        //拿到所有参数列表
        System.out.println(JSON.toJSONString(pjp.getArgs()));
        Parameter[] parameters = method.getParameters();
        System.out.println(JSON.toJSONString(parameters));
        //拿到注解方法的值
        String name = method.getAnnotation(Log.class).name();
        System.out.println("name:"+"\t"  +name);
        try {
            //必需
            Object ret = pjp.proceed(pjp.getArgs());
            return ret;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new Exception();
    }
}
