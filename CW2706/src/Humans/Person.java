package Humans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    static int count;
    String name;
    String surname;
    Calendar bDay;
    String phoneNumber;
    String address;
    String city;
    String country;
    public Person(){
        this("Jhon","Dou",new GregorianCalendar(2023,Calendar.JANUARY,1),"0",
                "Unknown","Unknown","Unknown");
    }

    public Person(String name, String surname, Calendar bDay, String phoneNumber, String address, String city, String country) {
        this.name = name;
        this.surname = surname;
        this.bDay = bDay;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        count++;
    }

    @Override
    public String toString() {
        return this.name + " " +
                this.surname +
                ", birth" +
                this.bDay.getTime() +
                ", from " +
                this.country +
                ", " +
                this.city +
                ", " +
                this.address +
                ". Phone number" +
                this.phoneNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Calendar getbDay() {
        return bDay;
    }
    public void setbDay(Calendar bDay) {
        this.bDay = bDay;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNubmer(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public static int getCount() {
        return count;
    }
}
