package com.gulukal.cityservice.controller;


import com.gulukal.cityservice.entity.City;
import com.gulukal.cityservice.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {


    @Autowired
    CityServiceImpl cityServiceImpl;

    @GetMapping("/")

    public List<City> getAllItem() {
        return cityServiceImpl.getAll();
    }

    @GetMapping("/{cityid}")

    public City getSingle(@PathVariable("cityid") long id) {
        return cityServiceImpl.getById(id);
    }

    @PostMapping("/")

    public City create(@RequestBody City city) {
        return cityServiceImpl.create(city);
    }

    @PutMapping("/{cityid}")

    public City update(@RequestBody City city, @PathVariable("cityid") long id) {
        return cityServiceImpl.update(city, id);
    }

    @DeleteMapping("/{cityid}")

    public HttpStatus delete(@PathVariable("cityid") long id) {
        cityServiceImpl.delete(id);
        return HttpStatus.OK;
    }


}
