package homework5.person.homework5.contractor;

import homework5.person.Employee;
import homework5.person.Experience;
import homework5.person.homework5.JobType;

import java.util.Objects;

public class Qa extends Employee {

    private int rate;
    private char category;
    private static final int BASIC_RATE = 20;


    public Qa(String fullName, int age, String job, int expirience) {
        super(fullName, age, job, expirience);
    }

    @Override
    public void printInfo() {
        String info = new StringBuilder().append(fullName).append(age).append(getJob("QA")).append(salary).toString();
        System.out.println(info);
    }

    @Override
    public double getSalary(double workingDays) {
        double salary;
        salary = workingDays*rate*0.9;
        return salary;
    }

    @Override
    public String getJob(String job) {
        return JobType.QA.toString() + exp;
    }

    //getters
    @Override
    public int getRate(){
        countRate(exp);
        return this.rate;
    }

    public char getCategory() {
        return this.category;
    }


    //setters
    public int setRate(int rating){
        return this.rate = rating;
    }
    public int setRate(int rating, char category){
        return this.rate = rating;
    }
    public char setCategory (char categories) {
        return this.category = categories;

    }

    private void countRate (Experience experience){
        double koef = 0;
        if (experience == Experience.JUNIOR)  {
            koef = 1;
        }
        if (experience == Experience.MIDDLE) {
            koef = 2.5;
        }
        if (experience == Experience.SENIOR) {
            koef = 3;
        }
        double draftRate = BASIC_RATE * koef ;
        if (getCategory() != 0) {
            draftRate=draftRate*1.5;
        }
        draftRate = BASIC_RATE * koef;
        rate = (int)draftRate;
    }
/*    private void expirienceValidation(int expirience) {
        if (expirience < 0 || expirience > 90) {
            System.out.println("you are lier or retired");
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qa qa = (Qa) o;
        return rate == qa.rate && category == qa.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, category);
    }
    @Override
    public Qa clone() {
        try {
            return (Qa)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }
}
