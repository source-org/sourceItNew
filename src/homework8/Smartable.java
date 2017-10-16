package homework8;

import java.util.Map;
import java.util.Set;

/**
 * Created by AlexS on 14.10.2017.
 */
public interface Smartable {

    Map<Character, Integer> letterFounder(String phrase);

    boolean isUnique(Map<String, String> map);

    Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2);

    Set<String> removeEvenLength(Set<String> set);

}

