package ru.mirea.inbo_05_19.Kuznetsov;

public class Customer {
    String firstName;
    String secondName;
    int age;
    Address address;
    Customer MATURE_UNKNOWN_CUSTOMER;
    Customer NOT_MATURE_UNKNOWN_CUSTOMER;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}