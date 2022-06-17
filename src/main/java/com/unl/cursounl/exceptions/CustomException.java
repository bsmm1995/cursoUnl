package com.unl.cursounl.exceptions;

/**
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public class CustomException extends RuntimeException {
  public CustomException(String msg) {
    super(msg);
  }
}
