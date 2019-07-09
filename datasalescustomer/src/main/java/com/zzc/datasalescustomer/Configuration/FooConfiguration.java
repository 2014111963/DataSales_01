package com.zzc.datasalescustomer.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class FooConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();  //RandomRule ： 负载均衡规则：随机
    }
}
