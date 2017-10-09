package homework5.person;

public class FactoryProducer {
    public static AbstarctFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Employee")) {
            return new EmployeeFactory();
        }
        else if (choice.equalsIgnoreCase("Person")) {
            return new PersonFactory();
        } else {return null;}
    }
}

