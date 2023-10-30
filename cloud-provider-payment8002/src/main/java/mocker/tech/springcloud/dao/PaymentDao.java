/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.springcloud.dao;

import mocker.tech.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mocker Li
 * @date 2023/10/29
 */
@Mapper
public interface PaymentDao
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
