package com.gulukal.personservice.controller;


import com.gulukal.personservice.pojo.Departmant;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DepartmantController {

    @Autowired
    EurekaClient client;

    public Departmant getDepartmantName(long id) {

        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo info = client.getNextServerFromEureka("boost-dep-app", false);
        String url = info.getHomePageUrl() + "/api/v1/departmant/" + id;  //8083
        return restTemplate.getForObject(url, Departmant.class);

    }
}
