package homework3;

import java.util.Arrays;

public class WordSize {

    public void words (String sentence) {
        if (sentence == null){ return; }

        String [] wordArray = sentence.split(" ");
        int max = 0;
        int min = sentence.length();
        String[] allWords = new String[wordArray.length];
        int counter = 0;

        for (String word : wordArray) {
            if (word.length() < min) {
                min = word.length();
            }
            if (word.length() > max) {
                max = word.length();
            }
        }
        for (String word : wordArray) {
            int length = word.length();
            if (length == max || length == min) {
                allWords[counter++]=word;
            }
        }
        System.out.println(Arrays.toString(allWords));
    }
}
