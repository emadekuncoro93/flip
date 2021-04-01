package com.emade.apps.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class DisbursementRequest {
  private String bankCode;
  private String accountNumber;
  private Integer amount;
  private String remark;
}