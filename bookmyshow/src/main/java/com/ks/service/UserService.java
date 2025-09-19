package com.ks.service;

import com.ks.dto.*;

public interface UserService {
  SignupUserResponseDto signupUser(SignupUserRequestDto req);
  LoginResponseDto login(LoginRequestDto req);
}
