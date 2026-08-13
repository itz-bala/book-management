package main.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse_1 {

    private LocalDateTime timestamp;
    private int status;
    private String ErrorMessage;
    private Map<String, String> errors;



}
