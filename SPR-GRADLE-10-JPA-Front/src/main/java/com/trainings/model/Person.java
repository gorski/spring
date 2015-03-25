package com.trainings.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "persons")
//@NamedQuery(name = "Person.findByName",
//        query = "SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(?1)")

@Entity
@Table(name = "persons")
@NamedQuery(name = "Person.findByName",
        query = "SELECT p FROM Person p WHERE LOWER(p.lastName) LIKE LOWER(?1) OR LOWER(p.firstName) LIKE LOWER(?1)")
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


    // slave of the relation - optional, used to render view
    @OneToOne(mappedBy = "person", optional = true)
    private Address address;

    // slave of the relation - optional, used to render view
    @OneToMany(mappedBy="person", cascade = CascadeType.REFRESH)
    private List<MobilePhone> mobilePhones;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(List<MobilePhone> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    @Transient
    public String getName() {
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
