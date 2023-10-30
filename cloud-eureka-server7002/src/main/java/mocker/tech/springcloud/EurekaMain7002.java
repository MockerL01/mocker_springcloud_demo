/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */
package mocker.tech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Mocker Li
 * @date 2023/10/29
 */
@SpringBootApplication
@EnableEurekaServer // 记得要写，不然无法通过service-url进行访问
public class EurekaMain7002
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
