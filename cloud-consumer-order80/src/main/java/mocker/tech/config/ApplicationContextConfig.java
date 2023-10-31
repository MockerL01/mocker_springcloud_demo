/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mocker Li
 * @date 2023/10/29
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
//    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    // 适用自定义的LoadBalanced时要去掉
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
