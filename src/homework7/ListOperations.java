package homework7;

import java.util.*;

public class ListOperations {

    public List<Integer> removeInRange(List<Integer> list, int element, int start, int end){
        List<Integer> copyList = new ArrayList<>();

        List<Integer> resultList = null;
        return resultList;
    }
    public int countCommon(List<Integer> list1, List<Integer> list2) throws NullPointerException {
        if (list1 == null || list2 == null)
            throw new NullPointerException("Array is null");
        Set <Integer> intSet = new HashSet<>();
        int resultSize;
        for(Integer first : list1) {
            for (Integer second: list2) {
                intSet.add(first);
                intSet.add(second);
            }
        }
        resultSize = intSet.size();
        return resultSize;
    }

    public int maxOccurrences(List<Integer> list) {
        int counter = 0;
        int index = 0;
        List <Integer> interimList = new ArrayList<>();
        for (int i=0; i < list.size()-1; i++){
            for (int j=0; j < list.size(); i++) {
                if (list.get(i).equals(list.get(j))) {
                    counter++;
                } else if (index !=i) {
                    interimList.add(counter);
                    counter = 0;
                    index++;
                }
            }
        }
        interimList.add(counter);
        Integer max = Collections.max(interimList);
        return max;
    }
}
