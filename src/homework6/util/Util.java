package homework6.util;

import homework6.IllegalResourceException;

public class Util {

    public static <T> T arrayIndexSearcher(T[] array, int index) throws IndexOutOfBoundsException,IllegalArgumentException {
        return array[index];
    }

    public int castMethod (String phrase) throws ClassCastException, NullPointerException, NumberFormatException{
        return Integer.valueOf(phrase);
    }
    public double multiCast (Object object) throws ClassCastException, NullPointerException, NumberFormatException{
        String firstCast = object.toString();
        Double secondCast = Double.parseDouble(firstCast);
        return secondCast;
    }
    public Resource resourceChecker(Resource resource) throws IllegalResourceException, NullPointerException {
        try {
            resource.getResource();
        }
        catch (NullPointerException e)
        {
            e.getCause();
        }
        finally {
           throw new IllegalResourceException("exception");
        }
    }

}