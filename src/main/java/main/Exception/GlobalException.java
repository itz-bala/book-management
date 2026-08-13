package main.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse_1> handleValidation(MethodArgumentNotValidException ex){


        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(e->errors.put(e.getField(),e.getDefaultMessage()));

        ErrorResponse_1 response=new ErrorResponse_1(

              LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "bad request validation failed",
                errors
        );

  return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse_2> handleNotFound(ResourceNotFoundException ex){

        ErrorResponse_2 response=new ErrorResponse_2(

                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Resource not found "
        );

        return new  ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse_2> handleException(Exception ex){


        ErrorResponse_2 response=new ErrorResponse_2(

                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "internal server error"
        );

        return new   ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
