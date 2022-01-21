package com.gulukal.depertmantservice.service;

import com.gulukal.depertmantservice.entity.Departmant;
import com.gulukal.depertmantservice.exception.ResourceNotFoundException;
import com.gulukal.depertmantservice.repository.DepartmantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DepartmantServiceImpl implements EntityService<Departmant>{


    @Autowired
    DepartmantRepository departmantRepository;

    @Override
    public Departmant create(Departmant entity) {
        return departmantRepository.save(entity);
    }

    @Override
    public Departmant update(Departmant entity, long id) {

        Departmant departmant=getById(id);
        departmant.setId(entity.getId());
        departmant.setName(entity.getName());
        return departmantRepository.save(entity);
    }

    @Override
    public List<Departmant> getAll() {
        return departmantRepository.findAll();
    }

    @Override
    public Departmant getById(long id) {

        Optional<Departmant> departmantdb = this.departmantRepository.findById(id);
        if(departmantdb.isPresent()) {
            return departmantdb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public void delete(long id) {

        Departmant departmantGetById = getById(id);
        departmantRepository.delete(departmantGetById);

    }
}
