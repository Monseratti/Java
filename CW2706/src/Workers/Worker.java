package Workers;

import Humans.Person;

public abstract class Worker {
    Person person;
    public Worker(){
        this(new Person());
    }
    public Worker(Person person){
        this.person = person;
    }
    public abstract void Print();
}
