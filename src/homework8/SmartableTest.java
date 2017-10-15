package homework8;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by AlexS on 14.10.2017.
 */
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

    private static Map<String,String> getNonUniqueMap () {
        Map<String, String> mapNonUnique = new HashMap<>();

        mapNonUnique.put("Alex","Shymel");
        mapNonUnique.put("Tetiana","Shymel");
        mapNonUnique.put("Bart","Simpson");
        mapNonUnique.put("Ned","Flanders");
        mapNonUnique.put("Marry", "Cartmann");
        return mapNonUnique;
    }

    @Test(expected = NullPointerException.class)
    public void testLetterFounderWithNullAsAnArgument() throws NullPointerException{
        //arrange
        SmartableImpl sm = new SmartableImpl();
        //action
        sm.letterFounder("This is really looooong story");
        sm.letterFounder(null);
    }
    @Test
    public void testIsUnique(){
        //arrange
        //action
        SmartableImpl sm = new SmartableImpl();
        boolean uniques = sm.isUnique(getUniqueMap());
        boolean nonUniques = sm.isUnique(getNonUniqueMap());
        //assertion
        assertEquals(true, uniques);
        assertEquals(false, nonUniques);
    }
    @Test
    public void testIntersect(){
        //arrange
        SmartableImpl sm = new SmartableImpl();
        //action
        Map<String, String> resultMap = sm.intersect(getUniqueMap(), getNonUniqueMap());
        String key = null;
        String value = null;
        for (Map.Entry<String, String> entry : resultMap.entrySet() ) {
             key = entry.getKey();
             value = entry.getValue();
            System.out.println(key+" "+value);
        }
        //assertion
        assertEquals("MarryCartmann", key+value);
    }
    @Test
    public void removeEvenLength(){
        //arrange
        //action
        SmartableImpl sm = new SmartableImpl();
        Set newSet = new HashSet<>(getUniqueMap().values());
        //assertion
        int size = sm.removeEvenLength(newSet).size();
        assertEquals(3, size);
    }
}
