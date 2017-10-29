package homework11;

public class InsertSort {

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

}
