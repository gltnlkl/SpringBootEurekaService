package com.gulukal.depertmantservice.controller;

import com.gulukal.depertmantservice.pojo.City;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {

    @Autowired
    EurekaClient client;

    public City getCityName(long id) {

        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo info = client.getNextServerFromEureka("boost-city-app", false);
        String url = info.getHomePageUrl() + "/api/v1/city/" + id;  //8083
        return restTemplate.getForObject(url, City.class);

    }

}
