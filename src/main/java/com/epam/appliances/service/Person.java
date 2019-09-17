package com.epam.appliances.service;

import java.util.Objects;

public abstract class Person {

    protected String name;
    protected String surname;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) &&
                getSurname().equals(person.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

}
