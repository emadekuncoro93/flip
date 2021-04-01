package com.emade.apps.controllers;

import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.services.api.DisburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/disburse")
public class DisburseController {

  @Autowired
  private DisburseService disburseService;

  @PostMapping
  public Object saveData(@RequestBody DisbursementRequest request){
    return disburseService.saveDisbursement(request);
  }

  @GetMapping
  public Object getData(){
    return disburseService.getDisbursementStatus(1);
  }
}
