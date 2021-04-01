package com.emade.apps.services;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import java.math.BigInteger;

public class GeneralTestVariable {
  public static final DisbursementRequest DISBURSEMENT_REQUEST = DisbursementRequest.builder()
      .accountNumber("test")
      .amount(100)
      .bankCode("test")
      .remark("test").build();
  public static final Disbursement DISBURSEMENT = Disbursement.builder()
      .status("test")
      .id(BigInteger.valueOf(1)).build();

  public static final Disbursement DISBURSEMENT_2 = Disbursement.builder()
      .status("test2")
      .id(BigInteger.valueOf(1)).build();
}
