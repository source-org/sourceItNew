package homework3;

import Homework1.Person;

import java.util.*;

public class PersonListImpl implements OwnList {

    private Person [] personArr = new Person[0];


    @Override
    public int size() {
        return personArr.length;
    }

    @Override
    public boolean isEmpty() {
        if (personArr.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(o instanceof Person){
            for (Person a : personArr) {
                if (a.equals(o)) { return true; }
            }
        }
        return false;
    }

    @Override
    public Iterator<Person> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Person person) {
        personArr = Arrays.copyOf(personArr,personArr.length+1);
        personArr[personArr.length - 1] = person;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Person> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Person> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Person get(int index) {
        return null;
    }

    @Override
    public Person set(int index, Person element) {
        return null;
    }

    @Override
    public void add(int index, Person element) {

    }

    @Override
    public Person remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Person> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Person> listIterator(int index) {
        return null;
    }

    @Override
    public List<Person> subList(int fromIndex, int toIndex) {
        return null;
    }
}
