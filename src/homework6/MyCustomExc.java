package homework6;

public class MyCustomExc extends RuntimeException {

    public MyCustomExc (Throwable e) {
        initCause(e);
    }

}
