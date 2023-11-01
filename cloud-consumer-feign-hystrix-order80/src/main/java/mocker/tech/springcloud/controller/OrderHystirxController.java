/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import mocker.tech.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws InterruptedException {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

}
