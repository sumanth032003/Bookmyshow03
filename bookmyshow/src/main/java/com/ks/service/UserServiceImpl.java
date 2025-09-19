package com.ks.service;

import com.ks.dto.*;
import com.ks.model.User;
import com.ks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public SignupUserResponseDto signupUser(SignupUserRequestDto req) {
    SignupUserResponseDto resp = new SignupUserResponseDto();
    // validate input (basic)
    if (req.getEmail() == null || req.getEmail().isBlank()) {
      resp.setStatus(ResponseStatus.FAILED);
      resp.setMessage("Email is required");
      return resp;
    }
    if (userRepository.existsByEmail(req.getEmail())) {
      resp.setStatus(ResponseStatus.FAILED);
      resp.setMessage("User already registered with email");
      return resp;
    }
    // create user
    User u = new User();
    u.setName(req.getName());
    u.setEmail(req.getEmail());
    String hashed = passwordEncoder.encode(req.getPassword());
    u.setPassword(hashed);
    User saved = userRepository.save(u);

    resp.setStatus(ResponseStatus.SUCCESS);
    resp.setMessage("Signup successful");
    resp.setUserId(saved.getId());
    resp.setName(saved.getName());
    resp.setEmail(saved.getEmail());
    return resp;
  }

  @Override
  @Transactional(readOnly = true)
  public LoginResponseDto login(LoginRequestDto req) {
    LoginResponseDto resp = new LoginResponseDto();
    Optional<User> opt = userRepository.findByEmail(req.getEmail());
    if (opt.isEmpty()) {
      resp.setLoggedIn(false);
      resp.setMessage("User not registered");
      return resp;
    }
    User u = opt.get();
    boolean matches = passwordEncoder.matches(req.getPassword(), u.getPassword());
    resp.setLoggedIn(matches);
    resp.setMessage(matches ? "Login successful" : "Invalid credentials");
    return resp;
  }
}
