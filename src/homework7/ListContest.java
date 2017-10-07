package homework7;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListContest implements Operations {
    @Override
    public <T> ArrayList<T> arrayListOperations(ArrayList<T> arrayList) throws NullPointerException, IllegalArgumentException {
        if(arrayList == null) {
            throw new NullPointerException("Array is null");
        } else if (arrayList.isEmpty()) {
            throw new IllegalStateException("Array is empty");
        } else if (arrayList.size()<1001) {
            throw new IndexOutOfBoundsException("Array shouldn't be less than 1001 element");
        }
        for(int i = 0; i < arrayList.size()-1;i++) {
            List <T> sublist = arrayList.subList(arrayList.size()/2,arrayList.size()/2+1000);
            arrayList.removeAll(sublist);
        }
        int index = 0;
        for (int i = 0; i < 1000;i++) {
            Integer randomInt = new Random().nextInt(Integer.MAX_VALUE);
            arrayList.add(index++, (T) randomInt);
        }
        for(int i = 0; i < arrayList.size()-1;i++){
            List <T> sublist = arrayList.subList(arrayList.size()/2,arrayList.size()/2+10);
            arrayList.clear();
            arrayList.add(index++, (T) sublist);
        }
        return arrayList;
    }

    @Override
    public <T> LinkedList<T> linkedListOperations(LinkedList<T> linkedList) throws NullPointerException, IllegalArgumentException {
        return null;
    }
}
