package Homework2;

public class ArraySum {


    public int arraySumm(int [] array){
        int summ = 0;
        for (int i=0; i<array.length; i++) {
            summ = summ + array[i];
        }
        return summ;
    }
}
