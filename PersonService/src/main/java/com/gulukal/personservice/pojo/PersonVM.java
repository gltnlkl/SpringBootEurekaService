package com.gulukal.personservice.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonVM {


    long id;
    String name;
    String surname;
    String depid; //long id yi String haline getirdik
    String city;  //bunu ekledik String olarak



}
