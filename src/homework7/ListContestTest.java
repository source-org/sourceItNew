package homework7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListContestTest {
    private ArrayList<Integer> getArrayList(){
        ArrayList<Integer> a = new ArrayList<>();
        Integer variable = 0;
        for(int i = 0; i < 3000; i++) {
            if (i == 1000) {
                variable = 1;
            }
            if (i == 2000) {
                variable = 2;
            }
            a.add(variable);
        }
        return a;
    }

    private LinkedList<Integer> getLinkedList(){
        LinkedList<Integer> l = new LinkedList<>();
        Integer variable = 0;
        for(int i = 0; i < 3000; i++) {
            if (i == 1000) {
                variable = 1;
            }
            if (i == 2000) {
                variable = 2;
            }
            l.add(variable);
        }
        return l;
    }

    @Test
    public void testArrayListOperationsSuccessfullyReturnModifiedList(){
        //arrange
        ListContest listContest = new ListContest();
        //action
        ArrayList<Integer> result = listContest.arrayListOperations(getArrayList());

        //assertion
        //list 3000 el; 0-999 -> 2; 1000-1999-> 0; 2000-2499->1; 2500-2999->2;
        assertEquals(3000, result.size());
        assertEquals(new Integer(2), result.get(0));
        assertEquals(new Integer(2), result.get(999));
        assertEquals(new Integer(0), result.get(1000));
        assertEquals(new Integer(0), result.get(1999));
        assertEquals(new Integer(1), result.get(2000));
        assertEquals(new Integer(1), result.get(2499));
        assertEquals(new Integer(2), result.get(2500));
        assertEquals(new Integer(2), result.get(2999));
    }

    @Test(expected = NullPointerException.class)
    public void testArrayListOperationsWithNullAsParameter() throws NullPointerException{
        //arrange
        ListContest listContest = new ListContest();
        //action
        listContest.arrayListOperations(null);

    }

    @Test(expected = IllegalStateException.class)
    public void testArrayListOperationsWithEmptyList()throws IllegalStateException {
        //arrange
        ListContest listContest = new ListContest();
        ArrayList<Integer> emptyList = new ArrayList<>();
        //action
        listContest.arrayListOperations(emptyList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayListOperationsWithSmallList() throws IndexOutOfBoundsException {
        //arrange
        ListContest listContest = new ListContest();
        ArrayList<Integer> smallList = new ArrayList<>();
        smallList.add(1);
        //action
        listContest.arrayListOperations(smallList);
    }

    @Test
    public void testLinkedListOperationsSuccessfullyReturnModifiedList(){
        //arrange
        ListContest listContest = new ListContest();
        //action
        LinkedList<Integer> result = listContest.linkedListOperations(getLinkedList());
        //assertion
        //list 3000 el; 0-999 -> 2; 1000-1999-> 0; 2000-2499->1; 2500-2999->2;
        assertEquals(3000, result.size());
        assertEquals(new Integer(2), result.get(0));
        assertEquals(new Integer(2), result.get(999));
        assertEquals(new Integer(0), result.get(1000));
        assertEquals(new Integer(0), result.get(1999));
        assertEquals(new Integer(1), result.get(2000));
        assertEquals(new Integer(1), result.get(2499));
        assertEquals(new Integer(2), result.get(2500));
        assertEquals(new Integer(2), result.get(2999));
    }

    @Test(expected = NullPointerException.class)
    public void testLinkedListOperationsWithNullAsParameter() throws NullPointerException {
        //arrange
        ListContest listContest = new ListContest();
        LinkedList<Integer> nullList = null;
        //action
        listContest.linkedListOperations(nullList);
    }

    @Test(expected = IllegalStateException.class)
    public void testLinkedListOperationsWithEmptyList()throws IllegalStateException{
        //arrange
        ListContest listContest = new ListContest();
        LinkedList<Integer> emptyList = new LinkedList<>();
        //action
        listContest.linkedListOperations(emptyList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLinkedListOperationsWithSmallList()throws IndexOutOfBoundsException{
        ListContest listContest = new ListContest();
        LinkedList<Integer> smallList = new LinkedList<>();
        smallList.add(1);
        //action
        listContest.linkedListOperations(smallList);
    }
    @Test
    public void testUniqueArrayListValues() {
        //arrange
        ListContest listContest = new ListContest();
        //action
        ArrayList<Integer> result = listContest.uniqueArray(getArrayList());
        //assertion
        assertEquals(3, result.size());
        assertEquals(new Integer (0), result.get(0));
        assertEquals(new Integer (1), result.get(1));
        assertEquals(new Integer (2), result.get(2));
    }
}
