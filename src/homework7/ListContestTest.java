package homework7;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ListContestTest {
    private ArrayList<Integer> getArrayList(){
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < 3000; i++) {
            Integer variable = Integer.MAX_VALUE;
            a.add(variable);
        }
        return a;
    }

    private LinkedList<Integer> getLinkedList(){
        LinkedList<Integer> l = new LinkedList<>();
        for(int i = 0; i < 3000; i++) {
            Integer variable = Integer.MAX_VALUE;
            l.add(variable);
        }
        return l;
    }

    @Test
    public void testArrayListOperationsSuccessfullyReturnModifiedList(){
        //arrange
        ListContest listContest = new ListContest();
        //action
        int resultSize = listContest.arrayListOperations(getArrayList()).size();
        //assertion
        assertEquals(resultSize, 10);
    }

   /* @Test(expected = InvalidParameterException.class)
    public void testArrayListOperationsWithNullAsParameter() throws InvalidParameterException{
        //arrange
        ListContest listContest = new ListContest();
        Object nullObject = new Object();
        nullObject = null;
        //action
        ArrayList <?> valueList = getArrayList();
        listContest.arrayListOperations(valueList<nullObject>);
        listContest.arrayListOperations(getArrayList()<nullObject>);

    }*/

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
        ArrayList<Integer> smallList = new ArrayList<>(1);
        smallList.add(1);
        //action
        listContest.arrayListOperations(smallList);
    }

    @Test
    public void testLinkedListOperationsSuccessfullyReturnModifiedList(){
        //arrange
        ListContest listContest = new ListContest();
        //action
        int resultSize = listContest.linkedListOperations(getLinkedList()).size();
        //assertion
        assertEquals(resultSize, 10);
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
}
