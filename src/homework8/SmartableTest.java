package homework8;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class SmartableTest {
    private static Map<String, String> getUniqueMap() {
        Map<String, String> mapUnique = new HashMap<>();

        mapUnique.put("Alex", "Shymel");
        mapUnique.put("Doctor", "Haus");
        mapUnique.put("Marry", "Poppins");
        mapUnique.put("Eric", "Cartman");
        mapUnique.put("Marry", "Cartmann");
        return mapUnique;
    }

    private static Map<String, String> getNonUniqueMap() {
        Map<String, String> mapNonUnique = new HashMap<>();

        mapNonUnique.put("Alex", "Shymel");
        mapNonUnique.put("Tetiana", "Shymel");
        mapNonUnique.put("Bart", "Simpson");
        mapNonUnique.put("Ned", "Flanders");
        mapNonUnique.put("Marry", "Cartmann");
        return mapNonUnique;
    }

    private static Map<String, Integer> getIntegerStringMap1() {
        Map<String, Integer> map1 = new HashMap<>();

        map1.put("Alex", 26);
        map1.put("Tetiana", 27);
        map1.put("Bart", 15);
        map1.put("Ned", 60);
        map1.put("Marry", 35);
        return map1;
    }

    private static Map<String, Integer> getIntegerStringMap2() {
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("Alex", 26);
        map2.put("Milena", 30);
        map2.put("Bart", 15);
        map2.put("Olivia", 66);
        map2.put("George", 19);
        return map2;
    }

    @Test
    public void testLetterFounderWithNullAsAnArgument() throws NullPointerException {
        //arrange
        SmartableImpl sm = new SmartableImpl();
        Map<Character, Integer> resultNullMap = sm.letterFounder(null);
        Map<Character, Integer> resultEmptyMap = sm.letterFounder("");

        //assertion
        assertEquals(Collections.emptyMap(), resultNullMap);
        assertEquals(Collections.emptyMap(), resultEmptyMap);

    }

    @Test
    public void testLetterFounder() throws NullPointerException {
        //arrange
        String phrase = "This is really looooong story";
        SmartableImpl sm = new SmartableImpl();
        Map<Character, Integer> resultMap = sm.letterFounder(phrase);
        //action
        for(Character key : resultMap.keySet()){
            System.out.println(key+" "+resultMap.get(key));
        }
        //assertion
        assertEquals(14, resultMap.size());
        assertEquals(Integer.valueOf(6), resultMap.get('o'));
        assertEquals(Integer.valueOf(1), resultMap.get('g'));
        assertEquals(14, resultMap.size());
    }

    @Test
    public void testIsUnique() {
        //arrange
        SmartableImpl sm = new SmartableImpl();
        //action
        boolean uniques = sm.isUnique(getUniqueMap());
        boolean nonUniques = sm.isUnique(getNonUniqueMap());
        //assertion
        assertEquals(true, uniques);
        assertEquals(false, nonUniques);
    }

    @Test
    public void testIntersect() {
        //arrange
        SmartableImpl sm = new SmartableImpl();
        //action
        Map<String, Integer> resultMap = sm.intersect(getIntegerStringMap1(), getIntegerStringMap2());
        //assertion
        assertEquals(2, resultMap.size());
        assertNotNull(resultMap.get("Alex"));
        assertNotNull(resultMap.get("Bart"));
        assertEquals(Integer.valueOf(26), resultMap.get("Alex"));
        assertEquals(Integer.valueOf(15), resultMap.get("Bart"));
    }

    @Test
    public void testRemoveEvenLength() {
        //arrange
        SmartableImpl sm = new SmartableImpl();
        Set<String> initialSet = new HashSet<>();
        initialSet.add("Alex");
        initialSet.add("Bart");
        initialSet.add("Georg");
        initialSet.add("Denis");
        //action
        int size = sm.removeEvenLength(initialSet).size();
        Set<String> resultSet = sm.removeEvenLength(initialSet);
        //assertion
        assertEquals(2, size);
        for (String value : resultSet) {
            assertFalse(value.length() % 2 == 0);
        }
    }
}
