package main.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse_2 {


    private LocalDateTime timestamp;
    private int status;
    private String  ErrorMessage;

}
