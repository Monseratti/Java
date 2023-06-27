import java.util.Date;

public class Person {
    String name;
    String surname;
    Date bDay;
    String phoneNumber;
    String address;
    String city;
    String country;

    public Person(String name, String surname, Date bDay, String phoneNumber, String address, String city, String country) {
        this.name = name;
        this.surname = surname;
        this.bDay = bDay;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return this.name + " " +
                this.surname +
                ", birth" +
                this.bDay +
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
    public Date getbDay() {
        return bDay;
    }
    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
    public String getPhoneNubmer() {
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
}
