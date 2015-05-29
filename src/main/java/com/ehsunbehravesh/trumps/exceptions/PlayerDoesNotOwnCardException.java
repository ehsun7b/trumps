package com.ehsunbehravesh.trumps.exceptions;

/**
 *
 * @author Ehsun Behravesh
 */
public class PlayerDoesNotOwnCardException extends Exception {

  public PlayerDoesNotOwnCardException(String message) {
    super(message);
  }  
}
