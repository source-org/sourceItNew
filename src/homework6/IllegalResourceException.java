package homework6;

public class IllegalResourceException extends Exception {

    private String message = "exception explanation message";

    public IllegalResourceException (String message){
        super(message);
    }

    public String getMessage () {
        return this.message;
    }
}
