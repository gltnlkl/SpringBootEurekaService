package com.gulukal.cityservice.service;


import com.gulukal.cityservice.entity.City;
import com.gulukal.cityservice.exception.ResourceNotFoundException;
import com.gulukal.cityservice.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements EntityService<City> {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City create(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public City update(City entity, long id) {

        City city=getById(id);
        city.setId(entity.getId());
        city.setName(entity.getName());
        return cityRepository.save(entity);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(long id) {

        Optional<City> citydb = this.cityRepository.findById(id);
        if(citydb.isPresent()) {
            return citydb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public void delete(long id) {

        City cityGetById = getById(id);
        cityRepository.delete(cityGetById);

    }

}
