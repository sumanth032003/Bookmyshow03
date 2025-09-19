package com.ks.dto;

import com.ks.dto.ResponseStatus;

public class SignupUserResponseDto {
  private ResponseStatus status;
  private String message;
  private Long userId;
  private String name;
  private String email;

  // getters & setters
  public ResponseStatus getStatus() { return status; }
  public void setStatus(ResponseStatus status) { this.status = status; }
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }
  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
