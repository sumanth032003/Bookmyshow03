package com.ks.dto;

public class LoginResponseDto {
  private boolean isLoggedIn;
  private String message;

  // getters & setters
  public boolean isLoggedIn() { return isLoggedIn; }
  public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }
}

