package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.services.api.BigFlipService;
import java.math.BigInteger;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BigFlipServiceImpl implements BigFlipService {
  private static final Logger LOGGER = LoggerFactory.getLogger(BigFlipServiceImpl.class);

  private final RestTemplate restTemplate;

  @Value("${bigFlip.url}")
  private String apiUrl;

  @Value("${bigFlip.key}")
  private String apiKey;

  public BigFlipServiceImpl(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public Disbursement disbursement(DisbursementRequest disbursementRequest){
    String url = apiUrl + "/disburse";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add("Authorization", apiKey);

    MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    map.add("remark", disbursementRequest.getRemark());
    map.add("account_number", disbursementRequest.getAccountNumber());
    map.add("bank_code", disbursementRequest.getBankCode());
    map.add("amount", disbursementRequest.getAmount().toString());

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
    ResponseEntity<Disbursement> response = null;
    try {
      response = restTemplate.postForEntity( url, request , Disbursement.class );
    }catch (Exception ex){
      LOGGER.error("failed to call bigFlip", ex);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    return Optional.ofNullable(response).map(ResponseEntity::getBody).orElse(null);
  }

  @Override
  public Disbursement disbursementStatus(BigInteger id){
    String url = apiUrl + "/disburse/" + id;
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add("Authorization", apiKey);
    HttpEntity request = new HttpEntity(headers);
    ResponseEntity<Disbursement> response = null;
    try {
      response = this.restTemplate.exchange(url, HttpMethod.GET, request, Disbursement.class);
    }catch (Exception ex){
      LOGGER.error("failed to call bigFlip", ex);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data not found");
    }
    return Optional.ofNullable(response).map(ResponseEntity::getBody)
        .orElse(Disbursement.builder().build());
  }
}
