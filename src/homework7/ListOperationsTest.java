package homework7;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ListOperationsTest {
    public class ListContestTest {
        private ArrayList<Integer> getArrayListOne() {
            ArrayList<Integer> a = new ArrayList<>();
            Integer variable = 0;
            for (int i = 0; i < 12; i++) {
                if (i == 4) {
                    variable = 1;
                }
                if (i == 8) {
                    variable = 2;
                }
                a.add(variable);
            }
            return a;
        }
    }

    private ArrayList<Integer> getArrayListTwo() {
        ArrayList<Integer> a = new ArrayList<>();
        Integer variable = 3;
        for (int i = 0; i < 9; i++) {
            if (i == 3) {
                variable = 1;
            }
            if (i == 3) {
                variable = 2;
            }
            a.add(variable);
        }
        return a;
    }

    @Test
    public void testCountCommon() {
        //arrange
        ListOperations lo = new ListOperations();
        //action

        //assertion
        assertEquals(2,lo.countCommon(getArrayListTwo(),getArrayListTwo()));
    }
    @Test
    public void testMaxOccurrences() {
        //arrange
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(1);
        listInt.add(1);
        listInt.add(2);
        listInt.add(2);
        listInt.add(4);
        listInt.add(0);
        listInt.add(0);
        ListOperations lo = new ListOperations();
        //action

        //assertion
        assertEquals(3 ,lo.maxOccurrences(listInt));
    }
}
