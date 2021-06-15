package com.lab1;

public class Person {
    private String name;
    private com.lab1.Dog dog;

    public Person(){}

    public Person(String name, com.lab1.Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public com.lab1.Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
