package Passports;

import Humans.Person;

import java.util.Arrays;

public class ForeignPassport extends Passport{

    String[] visaArray;
    public ForeignPassport(){
        this(new Person(),"Unknown",new String[1]);
    }
    public ForeignPassport(Person owner, String stateRegistrationBody,String[] visaArray){
        super(owner,stateRegistrationBody);
        this.visaArray = visaArray;
    }
    public String[] getVisaArray() {
        return visaArray;
    }
    public void setVisaArray(String[] visaArray) {
        this.visaArray = visaArray;
    }

    @Override
    public String toString() {
        return super.toString() +  "visaArray: [" + Arrays.toString(visaArray) +']';
    }
}
