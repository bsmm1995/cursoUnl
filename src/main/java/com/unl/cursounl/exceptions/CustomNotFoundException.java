package com.unl.cursounl.exceptions;

/**
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public class CustomNotFoundException extends RuntimeException {
  public CustomNotFoundException(String msg) {
    super(msg);
  }
}
