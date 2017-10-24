package homework11;

import java.util.ArrayList;

/**
 * Created by AlexS on 25.10.2017.
 */
public class Sorting {

    public int[] bubbleSort(int[] array) throws NullPointerException, IllegalArgumentException {
        boolean switcher = true;
        int j = 0;
        int temporary;
        if (array != null && array.length != 0) {
            while (switcher) {
                switcher = false;
                j++;
                for (int i = 0; i < array.length - j; i++) {
                    if(array[i] > array[i+1]){
                        temporary = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temporary;
                        switcher = true;
                    }
                }
            }
        }
        return array;
    }

    public <T> ArrayList<T> bubbleSort(ArrayList<T> collection) throws NullPointerException, IllegalArgumentException {
        if (collection != null && !collection.isEmpty()) {

        }
        return collection;
    }
}
