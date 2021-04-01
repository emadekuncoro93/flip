package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.repositories.api.DisbursementRepository;
import com.emade.apps.services.api.BigFlipService;
import com.emade.apps.services.api.DisburseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisburseServiceImpl implements DisburseService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DisburseServiceImpl.class);

  @Autowired
  private BigFlipService bigFlipService;

  @Autowired
  private DisbursementRepository disbursementRepository;

  @Override
  public Boolean saveDisbursement(DisbursementRequest request){
    bigFlipService.disbursement(request);
    Disbursement disbursement = Disbursement.builder()
        .id(1)
        .bankCode(request.getBankCode())
        .amount(request.getAmount())
        .accountNumber(request.getAccountNumber())
        .remark(request.getRemark())
        .build();
    disbursementRepository.save(disbursement);
    return true;
  }

  @Override
  public Object getDisbursementStatus(Integer id){
    return true;
  }
}
