package com.emade.apps.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disbursement")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disbursement {
  @Id
  private BigInteger id;
  private Integer amount;
  private String status;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date timestamp;
  @JsonProperty(value = "bank_code")
  private String bankCode;
  @JsonProperty(value = "account_number")
  private String accountNumber;
  @JsonProperty(value = "beneficiary_name")
  private String beneficiaryName;
  private String remark;
  private String receipt;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty(value = "time_served")
  private String timeServed;
  private Integer fee;
}
