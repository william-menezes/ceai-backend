package app.vercel.ceaiapp.service.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg) {
        super(msg);
    }
}
