/*
 * Copyright (c) 2023  mocker.tech, Inc. All rights reserved.
 */

package mocker.tech.lb;

import com.netflix.loadbalancer.RoundRobinRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mocker Li
 * @date 2023/10/31
 */
@Component
public class MyRoundRobin implements LoadBalancer{

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

    private final int getAndIncrement(int serverCount) {
        while (true) {
            int cur = nextServerCyclicCounter.get();
            int next = (cur + 1) % serverCount;
            if (this.nextServerCyclicCounter.compareAndSet(cur, next)) {
                return nextServerCyclicCounter.get();
            }
        }
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(getAndIncrement(serviceInstances.size()));
    }
}
