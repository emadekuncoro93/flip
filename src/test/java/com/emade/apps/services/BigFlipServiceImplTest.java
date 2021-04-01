package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import java.math.BigInteger;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BigFlipServiceImplTest {
  @InjectMocks
  private BigFlipServiceImpl bigFlipService;

  @Mock
  RestTemplate restTemplate;

  @Test
  void disbursementTest(){
    ReflectionTestUtils.setField(bigFlipService, "apiUrl", "url");
    ReflectionTestUtils.setField(bigFlipService, "apiKey", "key");
    DisbursementRequest disbursementRequest = DisbursementRequest.builder()
        .accountNumber("test")
        .amount(100)
        .bankCode("test")
        .remark("test").build();
    Disbursement disbursement = Disbursement.builder()
        .status("test")
        .id(BigInteger.valueOf(1)).build();
    ResponseEntity<Disbursement> responseEntity = ResponseEntity.of(Optional.of(disbursement));
    Mockito.when(this.restTemplate.postForEntity(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(new ResponseEntity(disbursement, HttpStatus.OK));
    bigFlipService.disbursement(disbursementRequest);
    Mockito.verify(restTemplate).postForEntity(Mockito.any(), Mockito.any(), Mockito.any());
  }

  @Test
  void disbursementStatusTest(){
    BigInteger id = BigInteger.valueOf(1);
    ReflectionTestUtils.setField(bigFlipService, "apiUrl", "url");
    ReflectionTestUtils.setField(bigFlipService, "apiKey", "key");
    DisbursementRequest disbursementRequest = DisbursementRequest.builder()
        .accountNumber("test")
        .amount(100)
        .bankCode("test")
        .remark("test").build();
    Disbursement disbursement = Disbursement.builder()
        .status("test")
        .id(BigInteger.valueOf(1)).build();
    ResponseEntity<Disbursement> responseEntity = ResponseEntity.of(Optional.of(disbursement));
    Mockito.when(this.restTemplate.exchange(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.eq(Disbursement.class)))
        .thenReturn(new ResponseEntity(disbursement, HttpStatus.OK));
    bigFlipService.disbursementStatus(id);
  }
}
