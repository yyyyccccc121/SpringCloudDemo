package com.example.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @LoadBalanced   //负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //@Bean
    public IRule iRule(){
        return new RetryRule();
    }
}
