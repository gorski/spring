package com.trainings.model;

import com.google.common.base.Objects;

import javax.persistence.*;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;

    // master of the relation (address->person)
    @OneToOne(optional = true)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}
