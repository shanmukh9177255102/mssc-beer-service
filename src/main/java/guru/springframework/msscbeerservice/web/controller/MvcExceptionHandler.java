package guru.springframework.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List>  validationErrorHandler(ConstraintViolationException exceptions){

        List<String> errorList = new ArrayList<>(exceptions.getConstraintViolations().size());
        exceptions.getConstraintViolations().forEach(e -> { errorList.add(e.toString());});

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
