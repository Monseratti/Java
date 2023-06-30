package Passports;

import Humans.Person;

public class Passport {
    Person owner;
    static int number = 0;
    static char serial = 'A';
    String stateRegistrationBody;
    String passportID;
    public Passport(){
        this(new Person(),"Unknown");
    }
    public Passport(Person owner, String stateRegistrationBody){
        this.owner = owner;
        this.stateRegistrationBody = stateRegistrationBody;
        this.passportID = setId();
    }

    private String setId(){
        int numberLenght = 4;
        number++;
        StringBuilder sb = new StringBuilder();
        if(number>9999){
            serial++;
            number = 0;
        }
        sb.append(serial);
        if(number<10) sb.append("000").append(number);
        else if (number<100) sb.append("00").append(number);
        else if (number<1000) sb.append("0").append(number);
        else sb.append(number);
        return sb.toString();
    }
    public String getPassportID() {
        return passportID;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getStateRegistrationBody() {
        return stateRegistrationBody;
    }

    public void setStateRegistrationBody(String stateRegistrationBody) {
        this.stateRegistrationBody = stateRegistrationBody;
    }
}
