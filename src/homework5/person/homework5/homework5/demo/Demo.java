package homework5.person.homework5.homework5.demo;

import homework5.person.Employee;
import homework5.person.homework5.EmployeeMaker;
import homework5.person.homework5.JobType;
import homework5.person.homework5.contractor.Qa;
import homework5.person.homework5.employee.Developer;

public class Demo {
    public static void main(String[] args) {


        Qa qa = new Qa("Vasya", 33, "Qa", 3);
        EmployeeMaker empMaker = new EmployeeMaker();

        qa.setJob(JobType.QA);
        empMaker.maker(qa);

        Employee employee = new Developer("Ivan", 33, "Python", 3);
        Employee empoloyee1 = new Qa("Maria", 25, "QA",1);


    }
}
