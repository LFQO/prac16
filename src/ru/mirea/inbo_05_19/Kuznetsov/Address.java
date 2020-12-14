package ru.mirea.inbo_05_19.Kuznetsov;

public final class Address {
    String city;
    int zipCode;
    String street;
    int buildingNumber;
    char buildingLetter;
    int apartment;
    public Address EMPTY_ADDRESS;

    public Address(String city, int zipCode, String street, int buildingNumber, char buildingLetter, int apartment) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartment() {
        return apartment;
    }
}