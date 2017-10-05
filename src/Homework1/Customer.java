package Homework1;

public class Customer extends Person {

    private String fullName;
    private int age;
    private String job;

    Customer(String fullName, int age, String job){
        this.fullName=fullName;
        this.age=age;
        this.job=job;
    }

    public String printInfo(){
        String info = fullName + " " + age + " " + job;
        return info;
    }



}