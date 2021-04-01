package com.emade.apps.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

  @GetMapping
  public Object getData(){
    Map<String, String> result = new HashMap<>();
    result.put("code", "200");
    result.put("data", "true");
    return result;
  }
}
