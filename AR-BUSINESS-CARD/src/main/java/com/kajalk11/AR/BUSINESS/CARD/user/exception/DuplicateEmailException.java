package com.kajalk11.AR.BUSINESS.CARD.user.exception;

public class DuplicateEmailException extends RuntimeException {
  public DuplicateEmailException(String Emailalreadyexits ) {

    super(Emailalreadyexits);
  }
}
