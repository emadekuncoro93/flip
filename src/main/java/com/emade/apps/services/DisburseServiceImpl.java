package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.repositories.api.DisbursementRepository;
import com.emade.apps.services.api.BigFlipService;
import com.emade.apps.services.api.DisburseService;
import java.math.BigInteger;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DisburseServiceImpl implements DisburseService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DisburseServiceImpl.class);

  @Autowired
  private BigFlipService bigFlipService;

  @Autowired
  private DisbursementRepository disbursementRepository;

  @Override
  public Disbursement saveDisbursement(DisbursementRequest request){
    Disbursement disbursement = bigFlipService.disbursement(request);
    if(null == disbursement){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    disbursementRepository.save(disbursement);
    return disbursement;
  }

  @Override
  public Disbursement getDisbursementStatus(BigInteger id){
    Disbursement disbursementFromDB = disbursementRepository.findFirstById(id);
    if(Objects.isNull(disbursementFromDB)){
      LOGGER.info("data not found id: {}", id);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    Disbursement disbursement = bigFlipService.disbursementStatus(id);
    if(!disbursementFromDB.getStatus().equals(disbursement.getStatus())){
      disbursementFromDB.setStatus(disbursement.getStatus());
      disbursementFromDB.setReceipt(disbursement.getReceipt());
      disbursementFromDB.setTimeServed(disbursement.getTimeServed());
      disbursementRepository.save(disbursementFromDB);
    }
    return disbursementFromDB;
  }

}
