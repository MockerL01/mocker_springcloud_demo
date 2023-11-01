/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.springcloud.service;

/**
 * @author Mocker Li
 * @date 2023/11/1
 */
public interface PaymentService {
    /**
     * 正常访问，一切OK
     * @param id id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    /**
     * 超时访问，演示降级
     * @param id id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id);

}
