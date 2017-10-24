package homework11;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortingTest {

    private final ArrayList <String> arrayList = new ArrayList<>();
    private final ArrayList<Person> personArray= new ArrayList<>();
    private final int simpleArray[] = {1,5,2,9,14,90,5};
    private final int sortedSimpleArray[] = {1,2,5,5,9,14,90};

    @Before
    public void setIntArrayList () {
        arrayList.add("Alex");
        arrayList.add("Josh");
        arrayList.add("Mike");
        arrayList.add("Don");
    }
    @Before
    public void setObjArrayList() {
        Person kate = new Person("Kate", 60);
        Person mary = new Person("Mary", 44);
        personArray.add(kate);
        personArray.add(mary);
    }
    @After
    public void dataRemover(){
        arrayList.clear();
        personArray.clear();

    }
    @Test
    public void testBubbleSort() throws NullPointerException {
        //arrange
        Sorting sort = new Sorting();
        Long startTimer = System.currentTimeMillis();
        //action
        sort.bubbleSort(arrayList);
        sort.bubbleSort(personArray);
        sort.bubbleSort(simpleArray);
        System.out.println("operation with int []: "+(System.currentTimeMillis()-startTimer)+" ms");
        //assertion
        for (int i = 0; i < simpleArray.length-1; i++){
            assertEquals(sortedSimpleArray[i], simpleArray[i]);
        }
        assertArrayEquals(sortedSimpleArray,simpleArray);
        //assertion
       // assertEquals("Don",arrayList.get(2));
       // assertEquals("Mike",arrayList.get(4));
       // assertEquals("Mary",personArray.get(1));
       // assertEquals("Kate",personArray.get(2));


    }
}
