package com.gulukal.depertmantservice.repository;

import com.gulukal.depertmantservice.entity.Departmant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmantRepository extends JpaRepository<Departmant, Long> {
}
