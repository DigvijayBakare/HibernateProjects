package com.tut;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Table(name = "newStudents")
public class Student {
    @Id
    private int id;
    private String name;
    private String city;

    private Certificate certificate;

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student() {
        super();
    }
    public void setCertificate(Certificate certify) {
        this.certificate = certify;
    }
    public Certificate getCertificate() {
        return certificate;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.name + " : " + this.city;
    }
}
