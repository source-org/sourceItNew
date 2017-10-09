package homework7;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.*;

public class ListContest implements Operations {
    @Override
    public <T> ArrayList<T> arrayListOperations(ArrayList<T> arrayList) throws NullPointerException, IllegalArgumentException {
        if(arrayList == null) {
            throw new NullPointerException("Array is null");
        } else if (arrayList.isEmpty()) {
            throw new IllegalStateException("Array is empty");
        } else if (arrayList.size()<1001) {
            throw new IndexOutOfBoundsException("Array shouldn't be less than 1001 element");
        }
        int size = arrayList.size();
        ArrayList <T> copyArray = new ArrayList<>();
        //list 3000 0-999 ->0; 1000 - 1999 -> 1; 2000-2999 -> 2
        for (int j = 0; j < size-1; j++) {
            if (j <= size/2-1 || j >= size/2+999) {
                copyArray.add(arrayList.get(j));
            }
        }
        //list 2000 el; 0-999 -> 0; 1000-1499 ->1; 1500-1999->2
        T element = copyArray.get(copyArray.size()-1);
        for (int i = 0; i < 1000;i++) {
            copyArray.add(i, element);
        }
        //list 3000 el; 0-999 -> 2; 1000-1999-> 0; 2000-2499->1; 2500-2999->2;
        return copyArray;
    }

    @Override
    public <T> LinkedList<T> linkedListOperations(LinkedList<T> linkedList) throws NullPointerException, IllegalArgumentException {
        if(linkedList == null) {
            throw new NullPointerException("LinkedList is null");
        } else if (linkedList.isEmpty()) {
            throw new IllegalStateException("LinkedList is empty");
        } else if (linkedList.size()<1001) {
            throw new IndexOutOfBoundsException("LinkedList shouldn't be less than 1001 element");
        }
        int size = linkedList.size();
        LinkedList <T> copyLinkedList = new LinkedList<>();
        //list 3000 0-999 ->0; 1000 - 1999 -> 1; 2000-2999 -> 2
        for (int j = 0; j < size-1; j++) {
            if (j <= size/2-1 || j >= size/2+999) {
                copyLinkedList.add(linkedList.get(j));
            }
        }
        //list 2000 el; 0-999 -> 0; 1000-1499 ->1; 1500-1999->2
        T element = copyLinkedList.get(copyLinkedList.size()-1);
        for (int i = 0; i < 1000;i++) {
            copyLinkedList.addFirst(element);
        }
        //list 3000 el; 0-999 -> 2; 1000-1999-> 0; 2000-2499->1; 2500-2999->2;
        return copyLinkedList;
    }

    public <T> ArrayList <T> uniqueArray(ArrayList<T> arrayList) throws NullPointerException,IllegalArgumentException {
        if (arrayList == null) {
            throw new NullPointerException("Array is null");
        } else if (arrayList.isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        Set <T> uniqueSet = new HashSet<>(arrayList);
        ArrayList<T> newArray = new ArrayList<>(uniqueSet);
        return newArray;
    }
}
