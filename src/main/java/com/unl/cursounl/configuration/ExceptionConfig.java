package com.unl.cursounl.configuration;

import com.unl.cursounl.exceptions.CustomException;
import com.unl.cursounl.exceptions.CustomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
  @ExceptionHandler(CustomNotFoundException.class)
  public ResponseEntity<Object> notFoundException(Exception e) {
    log.error(e.toString());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({CustomException.class, SQLException.class})
  public ResponseEntity<Object> exception(Exception e) {
    log.error(e.toString());
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
