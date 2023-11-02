/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import mocker.tech.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Mocker Li
 * @date 2023/11/1
 */
@RestController
@Slf4j
public class OrderHystirxController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    // 普通的服务降级
//    @HystrixCommand(fallbackMethod = "customFallBackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws Exception {
        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
            int tmp = 10/id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    // fallBackMethod需要保证函数参数表，返回值一样
    private String customFallBackMethod(Integer id){
        return "Custom fall back method."+id;
    }




}
