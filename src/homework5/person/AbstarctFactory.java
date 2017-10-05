package homework5.person;

import Homework1.Person;
import homework5.person.homework5.Working;

public abstract class AbstarctFactory {
    abstract Working getEmployee (Employee employee);
    abstract Person getPerson (Person person);
}
