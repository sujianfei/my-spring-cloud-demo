package com.feixiang.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger= LoggerFactory.getLogger(NacosController.class);

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        //Access through the combination of LoadBalanceClient and RestTemplate

        logger.error("hello skywalking consumer error");
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        String path = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), str);
        System.out.println("request path:" + path);
        String result = restTemplate.getForObject(path, String.class);


        return result;
    }


}