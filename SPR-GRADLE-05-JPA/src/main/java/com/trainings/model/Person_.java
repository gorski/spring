package com.trainings.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person, String> lastName;
}