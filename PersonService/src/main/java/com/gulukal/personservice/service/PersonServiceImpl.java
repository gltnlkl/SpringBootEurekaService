package com.gulukal.personservice.service;

import com.gulukal.personservice.entity.Person;

import com.gulukal.personservice.exception.ResourceNotFoundException;
import com.gulukal.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PersonServiceImpl implements EntityService<Person>{


    @Autowired
    PersonRepository personRepository;

    @Override
    public Person create(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public Person update(Person entity, long id) {

        Person person=getById(id);
        person.setId(entity.getId());
        person.setName(entity.getName());
        person.setSurname(entity.getSurname());
        person.setDepid(entity.getDepid());
        return personRepository.save(entity);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(long id) {

        Optional<Person> persondb = this.personRepository.findById(id);
        if(persondb.isPresent()) {
            return persondb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public void delete(long id) {

    //     Optional<Person> persondb=this.personRepository.findById(id);

    //    if(persondb.isPresent()){
    //        this.personRepository.delete(persondb.get());
    //    }else{
    //        throw new ResourceNotFoundException("Record not found with id: "+ id);
    //    }

        Person personGetById = getById(id);
        personRepository.delete(personGetById);

    }
}
