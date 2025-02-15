package app.vercel.ceaiapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CustomError {
    private Instant timestamp;
    private int status;
    private String error;
    private String path;

    public CustomError(Instant timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
