package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.repositories.api.DisbursementRepository;
import com.emade.apps.services.api.BigFlipService;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DisburseServiceImplTest {

  @InjectMocks
  private DisburseServiceImpl disburseService;

  @Mock
  BigFlipService bigFlipService;

  @Mock
  DisbursementRepository disbursementRepository;

  @Test
  void saveDisbursementTest(){
    DisbursementRequest disbursementRequest = DisbursementRequest.builder()
        .accountNumber("test")
        .amount(100)
        .bankCode("test")
        .remark("test").build();
    Disbursement disbursement = Disbursement.builder()
        .id(BigInteger.valueOf(1)).build();
    Mockito.when(bigFlipService.disbursement(disbursementRequest)).thenReturn(disbursement);
    disburseService.saveDisbursement(disbursementRequest);
    Mockito.verify(bigFlipService).disbursement(disbursementRequest);
    Mockito.verify(disbursementRepository).save(Mockito.any(Disbursement.class));
  }

  @Test
  void getDisbursementStatusTest(){
    BigInteger id = BigInteger.valueOf(1);
    DisbursementRequest disbursementRequest = DisbursementRequest.builder()
        .accountNumber("test")
        .amount(100)
        .bankCode("test")
        .remark("test").build();
    Disbursement disbursement = Disbursement.builder()
        .status("test")
        .id(BigInteger.valueOf(1)).build();
    Disbursement disbursement2 = Disbursement.builder()
        .status("test2")
        .id(BigInteger.valueOf(1)).build();
    Mockito.when(disbursementRepository.findFirstById(id)).thenReturn(disbursement);
    Mockito.when(bigFlipService.disbursementStatus(id)).thenReturn(disbursement2);
    disburseService.getDisbursementStatus(id);
    Mockito.verify(bigFlipService).disbursementStatus(id);
    Mockito.verify(disbursementRepository).save(Mockito.any(Disbursement.class));
  }


}
