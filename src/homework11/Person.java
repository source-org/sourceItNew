package homework11;

public class Person implements Comparable <Person> {
    protected int age;
    protected String name;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(person.age,person.age);
    }
}
