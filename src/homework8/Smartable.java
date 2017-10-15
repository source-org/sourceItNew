package homework8;

import java.util.Map;
import java.util.Set;

/**
 * Created by AlexS on 14.10.2017.
 */
public interface Smartable {

    void letterFounder(String phrase);

    boolean isUnique(Map<String, String> map);

    Map<String, String> intersect(Map<String, String> map1, Map<String, String> map2);

    Set<String> removeEvenLength(Set<String> set);

}

