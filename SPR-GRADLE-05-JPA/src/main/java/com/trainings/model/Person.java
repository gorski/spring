package com.trainings.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")

// @see PersonRepository - name of the query equals [Entity].[methodName]

// @NamedQuery better than @Query (compiles, no SQL injection)

@NamedQuery(name = "Person.findByName",
        query = "SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(?1)")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "creation_time", nullable = false)
    private Date creationTime;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;

    @Version
    private long version = 0;

    public Long getId() {
        return id;
    }

    public static Builder getBuilder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Transient
    public String  getName() {
        StringBuilder name = new StringBuilder();

        name.append(firstName);
        name.append(" ");
        name.append(lastName);

        return name.toString();
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public long getVersion() {
        return version;
    }

    public void update(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Person built;

        Builder(String firstName, String lastName) {
            built = new Person();
            built.firstName = firstName;
            built.lastName = lastName;
        }

        public Person build() {
            return built;
        }
    }

    protected void setId(Long id) {
        this.id = id;
    }
}
