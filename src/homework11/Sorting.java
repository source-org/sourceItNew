package homework11;

import java.util.ArrayList;


public class Sorting {

    private int [] initArray;

    public void setInitArray(int[] initArray) {
        this.initArray = initArray;
    }

    public int[] bubbleSort(int[] array) throws NullPointerException, IllegalArgumentException {
        boolean switcher = true;
        int j = 0;
        int temporary;
        if (array != null && array.length != 0) {
            while (switcher) {
                switcher = false;
                j++;
                for (int i = 0; i < array.length - j; i++) {
                    if (array[i] > array[i + 1]) {
                        temporary = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temporary;
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

    public int[] insertSort(int[] array) {
        int temporary;
        int j;
        for (int i = 1; i < array.length; i++) {
            temporary = array[i];
            for (j = i - 1; (j >= 0) && (array[j] > temporary); j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temporary;
        }
        return array;
    }

    private void quickSupport(int lowestIndex, int highestIndex) throws NullPointerException {
        int lowest = lowestIndex;
        int highest = highestIndex;
        if (lowest >= highest) {
            throw new NullPointerException("invalid array");
        }
        int pivot = initArray[lowest + (highest - lowest)] / 2;
        while (lowest <= highest) {
            while (initArray[lowest] < pivot) {
                lowest++;
            }
            while (initArray[highest] > pivot) {
                highest--;
            }
            if (lowest <= highest) {
                int temporary = initArray[lowest];
                initArray[lowest] = initArray[highest];
                initArray[highest] = temporary;
                lowest++;
                highest--;
            }
        }
        if (lowestIndex < highest) {
            quickSupport(lowestIndex, highestIndex);
        }
        if (lowest < highestIndex) {
            quickSupport(lowest, highestIndex);
        }
    }

    public void quickSort(int [] array) {
        int startIndex = 0;
        int endIndex = initArray.length - 1;
        quickSupport(startIndex, endIndex);
    }
}
