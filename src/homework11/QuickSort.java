package homework11;

import java.util.ArrayList;


public class QuickSort {

    private void quickSupport(int[] initArray, int lowestIndex, int highestIndex) throws NullPointerException {
        int lowest = lowestIndex;
        int highest = highestIndex;
        if (lowest >= highest) {
            throw new NullPointerException("invalid array");
        }
        int pivot = initArray[lowest + (highest - lowest) / 2];
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
            quickSupport(initArray, lowestIndex, highest);
        }
        if (lowest < highestIndex) {
            quickSupport(initArray, lowest, highestIndex);
        }
    }

    public int[] quickSort(int[] array) {
        quickSupport(array, 0, array.length - 1);
        return array;
    }
}
