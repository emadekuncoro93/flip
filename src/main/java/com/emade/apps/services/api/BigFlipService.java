package com.emade.apps.services.api;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import java.math.BigInteger;

public interface BigFlipService {
  Disbursement disbursement(DisbursementRequest request);
  Disbursement disbursementStatus(BigInteger id);
}
