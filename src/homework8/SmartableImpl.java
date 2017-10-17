package homework8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Collections;

public class SmartableImpl implements Smartable {

    @Override
    public Map<Character, Integer> letterFounder(String phrase) {
        Map<Character, Integer> map = new TreeMap<>();
        if (phrase != null && !phrase.isEmpty()) {
            for (int i = 0; i < phrase.length(); i++) {
                char c = phrase.charAt(i);
                int count = map.get(c) != null ? map.get(c) : 0;
                count++;
                map.put(c, count);
            }
        } else {
            return Collections.emptyMap();
        }
        return map;
    }

    @Override
    public boolean isUnique(Map<String, String> map) {
        return new HashSet<>(map.values()).size() == map.size();
    }

    @Override
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> resultMap = new HashMap<>();
        if (map1 != null && !map1.isEmpty() || map2 != null && !map2.isEmpty()) {
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                    if (entry1.getValue().equals(entry2.getValue()) && entry1.getKey().equals(entry2.getKey())) {
                        resultMap.put(entry1.getKey(), entry1.getValue());
                    }
                }
            }
        }
        return resultMap;
    }

    @Override
    public Set<String> removeEvenLength(Set<String> set) {
        Set<String> resultSet = new HashSet<>();
        if (set != null && !set.isEmpty()) {
            for (String element : set) {
                if (element.length() % 2 != 0) {
                    resultSet.add(element);
                }
            }
        }
        return resultSet;
    }
}
