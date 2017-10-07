package homework6.util;

import homework6.IllegalResourceException;

public class Util {

    public static <T> T arrayIndexSearcher(T[] array, int index) throws IndexOutOfBoundsException,IllegalArgumentException {
        try {
        return array[index];
        } catch (IndexOutOfBoundsException iob) {
            iob.getMessage();
        } catch (IllegalArgumentException iae) {
            iae.getStackTrace();
        }
        return array[index];
    }

    public int castMethod (String phrase) throws ClassCastException, NullPointerException, NumberFormatException{
        Integer result = null;
        try {
            if (phrase == null) {
                throw new NullPointerException();
            }
          result = Integer.valueOf(phrase);
        } catch (ClassCastException | NumberFormatException ce) {
            ce.printStackTrace();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
        return result;
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