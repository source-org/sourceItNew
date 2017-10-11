package homework7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for(int i = 0; i < 1000000; i++) {
                Integer variable = new Random().nextInt(Integer.MAX_VALUE);
                arrayList.add(variable);
                linkedList.add(variable);
            }
            Operations listOperations = new ListContest();
            Long startOperation = System.currentTimeMillis();
            listOperations.arrayListOperations(arrayList);
            System.out.println("List operation with ArrayList took: " + (System.currentTimeMillis() - startOperation) + " milliseconds");
            Long startOperation1 = System.currentTimeMillis();
            listOperations.linkedListOperations(linkedList);
            System.out.println("List operation with LinkedList took: " + (System.currentTimeMillis() - startOperation1) + " milliseconds");
    }
}
