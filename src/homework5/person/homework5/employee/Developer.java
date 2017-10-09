package homework5.person.homework5.employee;

import homework5.person.Employee;
import homework5.person.Experience;
import homework5.person.homework5.JobType;

import java.util.Arrays;
import java.util.Objects;

public class Developer extends Employee {

    private int rate;
    private char[] driverCategory;
    private String language;
    private static final int BASIC_RATE = 30;


    public Developer(String fullName, int age, String language, int experience) {
        super(fullName, age, language, experience);
    }

    public void setExpirience(Employee experience) {
        Employee exp = experience;
    }
    @Override
    public int getRate() {
        countRate(exp);
        return rate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCategory(char[] category) {
        setCategoryValidation(category);
        this.driverCategory = category;
    }
    public void setCategory(String category) {
        if (setCategoryValidation(category)){
            this.driverCategory = category.toCharArray();
        } else {
            System.out.println("invalid category");
        }
    }
    public char [] getCategory() {
        return driverCategory;
    }

    
    // VALIDATION
    private void rateValidation(int rate) {
        if (rate == 0 || rate < 0 || rate > 100) {
            System.out.println("rate should be from 1 to 100");
        }

    }
    private void setCategoryValidation(char[] category) {
        char[] validCategory = {'A', 'B', 'C', 'D', 'M'};
        for (int i = 0; i < category.length; i++) {
            for (int j = 0; j < validCategory.length; j++)
                if (validCategory[j] == category[i]) {
                    return;
                } else {
                    System.out.println("type a valid driver category");
                }
        }
    }
    private boolean setCategoryValidation(String category) {
        char[] validCategory = {'A', 'B', 'C', 'D', 'M'};
        if (category == null) {
            System.out.println("enter category");
            return false;
        }
        for (int i = 0; i < validCategory.length; i++) {
            if ((String.valueOf(validCategory[i]).equals(category))) {
                return true;
            }
        } return false;
    }
/*    private void expirienceValidation(int experience) {
        if (experience < 0 || experience > 90) {
            System.out.println("you are lier or retired");
        }
    }*/

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
        double draftRate = BASIC_RATE * koef;
        if (getCategory() != null) {
            draftRate=draftRate*1.5;
        }
        rate = (int)draftRate;
    }



    @Override
    public void printInfo() {
        String info = new StringBuilder().append(fullName).append(age).append(getJob("Developer")).append(salary).toString();
        System.out.println(info);
    }

    @Override
    public double getSalary(double workingDays) {
        double salary;
        salary = workingDays*rate;
        return salary;
    }

    @Override
    public String getJob(String job) {
        return JobType.DEVELOPER + getLanguage() + exp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Arrays.equals(driverCategory, developer.driverCategory);
    }
    @Override
    public int hashCode() {
        return Objects.hash(rate, driverCategory, language);
    }
    @Override
    public Developer clone() {
        try {
            return (Developer)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }
}
