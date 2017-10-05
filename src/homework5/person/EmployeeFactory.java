package homework5.person;

import Homework1.Person;
import homework5.person.homework5.JobType;
import homework5.person.homework5.Working;
import homework5.person.homework5.contractor.Qa;
import homework5.person.homework5.employee.Developer;

public class EmployeeFactory extends AbstarctFactory {
/*
    public static Working getEmployee(Employee employee) {
        if (employee == null) {return null;}
        if (employee.getJob().equalsIgnoreCase("developer")) {
            return new Developer();
        } else if (employee.getJob().equalsIgnoreCase("qa")) {
            return new Qa();
        } else {
            return null;
        }
    }*/

    @Override
    Working getEmployee(Employee employee) {
        if (employee == null) {return null;}
        if (employee.getJob() == JobType.DEVELOPER) {
            return new Developer();
        } else if (employee.getJob() == JobType.QA) {
            return new Qa();
        } else {
            return null;
        }
    }

    @Override
    Person getPerson(Person person) {
        return null;
    }
}
