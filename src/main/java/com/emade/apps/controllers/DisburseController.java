package com.emade.apps.controllers;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.services.api.DisburseService;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/disburse")
public class DisburseController {

  @Autowired
  private DisburseService disburseService;

  @PostMapping
  public Boolean saveData(@RequestBody DisbursementRequest request){
    return disburseService.saveDisbursement(request);
  }

  @GetMapping
  public Disbursement getData(@RequestParam BigInteger id){
    return disburseService.getDisbursementStatus(id);
  }
}
