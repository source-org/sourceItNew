package homework6.util;

import homework6.IllegalResourceException;

public class Resource {

    private int resource;

    Resource (int resource) {
        this.resource = resource;
    }

    public int getResource() throws IllegalResourceException {
        if(resource<0) {
            throw new IllegalResourceException("message");
        }
        return resource;
    }
}
