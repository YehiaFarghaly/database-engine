package exceptions;

public class DBAppException extends Exception {
    public DBAppException(String message) {
        super(message);
    }

    public DBAppException() {
        super();
    }

    public DBAppException(Exception e) {
        super(e);
    }


}
