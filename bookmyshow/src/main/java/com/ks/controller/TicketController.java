package com.ks.controller;

import com.ks.dto.*;
import com.ks.dto.ResponseStatus;
import com.ks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
  Mapping:
  GET  /user/signup  -> show signup form
  POST /user/signup  -> process signup (form -> signupUser)
  GET  /user/login   -> show login form
  POST /user/login   -> process login (form -> login)
*/

@Controller
@RequestMapping("/user")
public class TicketController {

  @Autowired
  private UserService userService;

  @GetMapping("/signup")
  public String signupForm(Model m){
    m.addAttribute("signupRequest", new SignupUserRequestDto());
    return "signup";
  }

  @PostMapping("/signup")
  public String signupUser(@ModelAttribute("signupRequest") SignupUserRequestDto req, Model m){
    SignupUserResponseDto resp = userService.signupUser(req);
    m.addAttribute("response", resp);
    if (resp.getStatus() == ResponseStatus.SUCCESS) {
      m.addAttribute("message", resp.getMessage());
      return "welcome";
    } else {
      m.addAttribute("error", resp.getMessage());
      return "signup";
    }
  }

  @GetMapping("/login")
  public String loginForm(Model m){
    m.addAttribute("loginRequest", new LoginRequestDto());
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute("loginRequest") LoginRequestDto req, Model m) {
    LoginResponseDto resp = userService.login(req);
    m.addAttribute("loginResponse", resp);
    if (resp.isLoggedIn()) {
      m.addAttribute("message", resp.getMessage());
      return "welcome";
    } else {
      m.addAttribute("error", resp.getMessage());
      return "login";
    }
  }
}
