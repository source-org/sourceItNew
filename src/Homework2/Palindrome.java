import java.util.*;

public class Palindrome {


    public void findPalindrome(int[] array) {
        String result = null;
        String [] resultArray = new String[array.length];
        int palindromeCounter = 0;
        for (int number : array) {
            String numberStr = String.valueOf(number);
            StringBuilder str = new StringBuilder(numberStr);
            str.reverse();
            if (str.toString().equals(numberStr)) {
                result = numberStr;
                resultArray[palindromeCounter++] = result;
            }
        }
        System.out.println(result);
        System.out.println(Arrays.toString(resultArray));
    }
}
