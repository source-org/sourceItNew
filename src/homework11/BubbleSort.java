package homework11;

import java.util.ArrayList;

public class BubbleSort {
    public int [] bubbleSort (int [] array) {
        int temporary;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++){
                if (array[j-1] > array[j]){
                    temporary = array[j-1];
                    array[j-1] = array [j];
                    array[j] = temporary;
                }
            }
        }
        return array;
    }
    public ArrayList <Person> bubbleSort(ArrayList<Person> collection) throws NullPointerException, IllegalArgumentException {
        if (collection != null && !collection.isEmpty()) {
            Person temporary;
            for (int i = 0; i < collection.size(); i++) {
                for (int j = 1; j < (collection.size() - i); j++) {
                    if (collection.get(j - 1).compareTo(collection.get(j)) > 0 ) {
                        temporary = collection.get(j - 1);
                        collection.set(j, collection.get(j-1));
                        collection.set(j, temporary);
                    }
                }
            }
        }
        return collection;
    }

    public ArrayList <String> bubbleSortName(ArrayList<String> collection) throws NullPointerException, IllegalArgumentException {
        if (collection != null && !collection.isEmpty()) {
            String temporary;
            for (int i = 0; i < collection.size(); i++) {
                for (int j = 1; j < (collection.size() - i); j++) {
                    if (collection.get(j - 1).compareTo(collection.get(j)) < 0 ) {
                        temporary = collection.get(j - 1);
                        collection.set(j, collection.get(j-1));
                        collection.set(j, temporary);
                    }
                }
            }
        }
        return collection;
    }
}
