package com.gulukal.depertmantservice.controller;


import com.gulukal.depertmantservice.entity.Departmant;
import com.gulukal.depertmantservice.pojo.DepartmantVM;
import com.gulukal.depertmantservice.service.DepartmantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departmant")
public class DepartmantController {

    @Autowired
    CityController cityController;

    @Autowired
    DepartmantServiceImpl departmantServiceImpl;

    @GetMapping("/")

    public List<Departmant> getAllItem() {
        return departmantServiceImpl.getAll();

    }

    @GetMapping("/{departmantid}")

    public Departmant getSingle(@PathVariable("departmantid") long id) {
        return departmantServiceImpl.getById(id);

//    public DepartmantVM getSingle(@PathVariable("departmantid") long id) {
//        DepartmantVM departmantVM = new DepartmantVM();
//        Departmant departmant = departmantServiceImpl.getById(id);
//        departmantVM.setId(departmant.getId());
//        departmantVM.setName(departmant.getName());
//
//        departmantVM.setCityid(cityController.getCityName(id).getName());
//
//        return departmantVM;
    }

    @PostMapping("/")

    public Departmant create(@RequestBody Departmant departmant) {
        return departmantServiceImpl.create(departmant);
    }

    @PutMapping("/{departmantid}")

    public Departmant update(@RequestBody Departmant departmant, @PathVariable("departmantid") long id) {
        return departmantServiceImpl.update(departmant, id);
    }

    @DeleteMapping("/{departmantid}")

    public HttpStatus delete(@PathVariable("departmantid") long id) {
        departmantServiceImpl.delete(id);
        return HttpStatus.OK;
    }

}
