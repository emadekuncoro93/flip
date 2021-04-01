package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
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
public class BigFlipServiceImplTest extends GeneralTestVariable {
  @InjectMocks
  private BigFlipServiceImpl bigFlipService;

  @Mock
  RestTemplate restTemplate;

  @Test
  void disbursementTest(){
    ReflectionTestUtils.setField(bigFlipService, "apiUrl", "url");
    ReflectionTestUtils.setField(bigFlipService, "apiKey", "key");
    ResponseEntity<Disbursement> responseEntity = ResponseEntity.of(Optional.of(DISBURSEMENT));
    Mockito.when(this.restTemplate.postForEntity(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(new ResponseEntity(DISBURSEMENT, HttpStatus.OK));
    bigFlipService.disbursement(DISBURSEMENT_REQUEST);
  }

  @Test
  void disbursementStatusTest(){
    BigInteger id = BigInteger.valueOf(1);
    ReflectionTestUtils.setField(bigFlipService, "apiUrl", "url");
    ReflectionTestUtils.setField(bigFlipService, "apiKey", "key");
    ResponseEntity<Disbursement> responseEntity = ResponseEntity.of(Optional.of(DISBURSEMENT));
    Mockito.when(this.restTemplate.exchange(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.eq(Disbursement.class)))
        .thenReturn(new ResponseEntity(DISBURSEMENT, HttpStatus.OK));
    bigFlipService.disbursementStatus(id);
  }
}
