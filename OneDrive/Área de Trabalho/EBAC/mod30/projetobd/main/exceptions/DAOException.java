package main.exceptions;

public class DAOException extends Exception {

    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
    
}
