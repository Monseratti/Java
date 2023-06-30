package Humans;

import java.util.Calendar;

public class Sailor extends Person {
    String workAbility;

    public String getWorkAbility() {
        return workAbility;
    }

    public void setWorkAbility(String workAbility) {
        this.workAbility = workAbility;
    }

    public Sailor(String name, String surname, Calendar bDay, String phoneNumber,
                  String address, String city, String country, String workAbility) {
        super(name, surname, bDay, phoneNumber, address, city, country);
        this.workAbility = workAbility;
    }

    @Override
    public String toString() {
        return super.toString() + ". Is a sailor. Abilities is " + workAbility;
    }
}
