package app.vercel.ceaiapp.service.exception;

public class ResourceNotFoundException extends RuntimeException  {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
