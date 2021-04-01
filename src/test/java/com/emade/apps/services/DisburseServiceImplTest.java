package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.repositories.api.DisbursementRepository;
import com.emade.apps.services.api.BigFlipService;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DisburseServiceImplTest extends GeneralTestVariable {

  @InjectMocks
  private DisburseServiceImpl disburseService;

  @Mock
  BigFlipService bigFlipService;

  @Mock
  DisbursementRepository disbursementRepository;

  @Test
  void saveDisbursementTest(){
    Mockito.when(bigFlipService.disbursement(DISBURSEMENT_REQUEST)).thenReturn(DISBURSEMENT);
    disburseService.saveDisbursement(DISBURSEMENT_REQUEST);
    Mockito.verify(bigFlipService).disbursement(DISBURSEMENT_REQUEST);
    Mockito.verify(disbursementRepository).save(Mockito.any(Disbursement.class));
  }

  @Test
  void getDisbursementStatusTest(){
    BigInteger id = BigInteger.valueOf(1);
    Mockito.when(disbursementRepository.findFirstById(id)).thenReturn(DISBURSEMENT);
    Mockito.when(bigFlipService.disbursementStatus(id)).thenReturn(DISBURSEMENT_2);
    disburseService.getDisbursementStatus(id);
    Mockito.verify(bigFlipService).disbursementStatus(id);
    Mockito.verify(disbursementRepository).save(Mockito.any(Disbursement.class));
  }


}
