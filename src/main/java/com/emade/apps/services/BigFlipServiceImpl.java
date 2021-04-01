package com.emade.apps.services;

import com.emade.apps.dto.request.DisbursementRequest;
import com.emade.apps.services.api.BigFlipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class BigFlipServiceImpl implements BigFlipService {
  private static final Logger LOGGER = LoggerFactory.getLogger(BigFlipServiceImpl.class);

  private final RestTemplate restTemplate;

  public BigFlipServiceImpl(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public Object disbursement(DisbursementRequest disbursementRequest){
    String url = "https://nextar.flip.id/disburse";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add("Authorization", "Basic SHl6aW9ZN0xQNlpvTzduVFlLYkc4TzRJU2t5V25YMUp2QUVWQWh0V0tadW1vb0N6cXA0MTo=");

    MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    map.add("remark", disbursementRequest.getRemark());
    map.add("account_number", disbursementRequest.getAccountNumber());
    map.add("bank_code", disbursementRequest.getBankCode());
    map.add("amount", disbursementRequest.getAmount().toString());

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

    ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
    System.out.println("+++++");
    System.out.println(response);
    return response;
  }
}
