package homework6;


import java.util.Arrays;
import java.util.Random;

public class Search {

    private int [] intArray;

    Search (int i) {
        if (i<0) {
            throw new NegativeArraySizeException("set positive index");
        }
        int [] array = new int [i];
        for (int j=0; j < array.length-1; j++) {
             array[j] = new Random().nextInt(array.length);
        }
        Arrays.sort(array);
        this.intArray = Arrays.copyOf(array, array.length);
    }

    public boolean binarySearch(int[] intArray, int value) {
        if (intArray == null) {
            System.out.println("Enter not null value");
            return false;
        }
        int n = intArray.length / 2;
        while (true) {
            if (n >= intArray.length) {
                return false;
            }
            if (value <= intArray[n]) {
                if (value == intArray[n]) {
                    System.out.println(n);
                    return true;
                }
                if (n==0) {
                    return  false;
                }
            } else if (value >= intArray[n]) {
                n = n+n/2;
            }

        }
    }
}
