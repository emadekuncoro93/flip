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
  public Boolean saveDisbursement(DisbursementRequest request){
    Disbursement disbursement = bigFlipService.disbursement(request);
    if(null == disbursement){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    disbursementRepository.save(disbursement);
    return true;
  }

  @Override
  public Disbursement getDisbursementStatus(BigInteger id){
    Disbursement disbursement = disbursementRepository.findFirstById(id);
    if(Objects.isNull(disbursement)){
      LOGGER.info("data not found id: {}", id);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    return disbursement;
  }
}
