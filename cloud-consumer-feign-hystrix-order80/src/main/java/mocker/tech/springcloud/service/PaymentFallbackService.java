/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Mocker Li
 * @date 2023/11/2
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "In Default PaymentFallbackService: paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) throws InterruptedException {
        return "In Default PaymentFallbackService: paymentInfo_TimeOut";
    }
}
