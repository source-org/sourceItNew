package homework8;

import java.util.*;

/**
 * Created by AlexS on 14.10.2017.
 */
public class SmartableImpl implements Smartable {

    @Override
    public void letterFounder(String phrase) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i=0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            int count = map.get(c)!=null?map.get(c):0;
            count++;
            map.put(c,count);
        }
        for (Character key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }

    @Override
    public boolean isUnique(Map<String, String> map) {
        boolean flag;
        Set newSet = new HashSet<>(map.values());
        if(map.size()!=newSet.size()) {
            flag = false;
        } else flag = true;
        return flag;
    }

    @Override
    public Map<String, String> intersect(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String,String> entry1 : map1.entrySet()){
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                if (entry1.getValue().equals(entry2.getValue()) && entry1.getKey().equals(entry1.getKey())) {
                    resultMap.put(entry1.getKey(), entry1.getValue());
                }
            }
        }
        return resultMap;
    }

    @Override
    public Set<String> removeEvenLength(Set<String> set) {
        Set <String> resultSet = new HashSet<>();
        Iterator iter = set.iterator();
        int counter = 0;
        while(iter.hasNext()) {
            iter.next();
            if(counter%2 == 0) {
                iter.remove();
            }
            counter++;
        }
        return resultSet;
    }
}
