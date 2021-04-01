package com.emade.apps.controllers;

import com.emade.apps.services.api.DisburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/disburse")
public class DisburseController {

  @Autowired
  private DisburseService disburseService;

  @PostMapping
  public Object saveData(){
    return disburseService.saveDisbursement(1);
  }

  @GetMapping
  public Object getData(){
    return disburseService.getDisbursementStatus(1);
  }
}
