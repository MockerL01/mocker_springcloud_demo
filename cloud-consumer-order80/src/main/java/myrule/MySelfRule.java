/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mocker Li
 * @date 2023/10/31
 */
@Configuration
public class MySelfRule {
    @Bean // 记得要加，不然无法载入
    public IRule myRule() {
        return new BestAvailableRule();
    }
}
