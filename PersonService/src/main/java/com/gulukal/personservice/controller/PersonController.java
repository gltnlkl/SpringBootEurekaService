package com.gulukal.personservice.controller;

import com.gulukal.personservice.entity.Person;
import com.gulukal.personservice.pojo.City;
import com.gulukal.personservice.pojo.Departmant;
import com.gulukal.personservice.pojo.PersonVM;
import com.gulukal.personservice.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    CityController cityController;
    @Autowired
    DepartmantController departmantController;
    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping("/")

    public List<Person> getAllItem() {
        return personServiceImpl.getAll();

    }

    @GetMapping("/{personid}")

    public PersonVM getSingle(@PathVariable("personid") long id) {

        PersonVM personVM = new PersonVM();
        Person person = personServiceImpl.getById(id);
        personVM.setId(person.getId());
        personVM.setName(person.getName());
        personVM.setSurname(person.getSurname());

        Departmant dep =departmantController.getDepartmantName(person.getDepid());
        personVM.setDepid(dep.getName());
        City city=cityController.getCityName(dep.getCityid());
        personVM.setCity(city.getName());
        return personVM;
    }

    @PostMapping("/")

    public Person create(@RequestBody Person person) {
        return personServiceImpl.create(person);
    }

    @PutMapping("/{personid}")

    public Person update(@RequestBody Person person, @PathVariable("personid") long id) {
        return personServiceImpl.update(person, id);
    }

    @DeleteMapping("/{personid}")

    public HttpStatus delete(@PathVariable("personid") long id) {
        personServiceImpl.delete(id);
        return HttpStatus.OK;
    }
}
