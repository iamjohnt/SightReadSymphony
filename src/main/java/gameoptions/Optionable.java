package gameoptions;

import exceptions.InvalidOptionsException;

public interface Optionable {

    public boolean isValid() throws InvalidOptionsException;
}
