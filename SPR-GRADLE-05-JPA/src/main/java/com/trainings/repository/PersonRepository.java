package com.trainings.repository;

import com.trainings.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository
        extends JpaRepository<Person, Long>,
        JpaSpecificationExecutor<Person> {

    // this works because  JpaSpecificationExecutor gives implementation of this met
    // :lastName - parameter taken from @Param

    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    public List<Person> find(@Param("lastName") String lastName);

    // @see Person - name of the query equals [Entity].[methodName]
    public List<Person> findByName(String lastName);


    // for advanced search : Hibernate Search / Lucene

}
