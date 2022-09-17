package com.pedro.springfun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

  private final BasicInfoService service;

  public BasicController(BasicInfoService service) {
    this.service = service;
  }

  @GetMapping
  public String home() {
    return "Welcome to spring fun";
  }

  @GetMapping("user-info")
  public UserInfo getUserInfo() {
    return service.getUserInfo();
  }
}