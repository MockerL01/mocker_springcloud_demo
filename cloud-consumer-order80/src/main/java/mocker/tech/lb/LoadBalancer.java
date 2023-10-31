/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Mocker Li
 * @date 2023/10/31
 */
public interface LoadBalancer {
    ServiceInstance choose(List<ServiceInstance> serviceInstances);
}
