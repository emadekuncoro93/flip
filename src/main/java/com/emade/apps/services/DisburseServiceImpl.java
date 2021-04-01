package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.repositories.api.DisbursementRepository;
import com.emade.apps.services.api.DisburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisburseServiceImpl implements DisburseService {

  @Autowired
  DisbursementRepository disbursementRepository;

  @Override
  public Boolean saveDisbursement(Object request){
    Disbursement disbursement = Disbursement.builder()
        .id(123)
        .bankCode("aa")
        .build();
    disbursementRepository.save(disbursement);
    return true;
  }

  @Override
  public Object getDisbursementStatus(Integer id){
    return true;
  }
}
