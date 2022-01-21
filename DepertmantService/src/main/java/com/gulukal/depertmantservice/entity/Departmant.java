package com.gulukal.depertmantservice.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Departmant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    long cityid;
}
