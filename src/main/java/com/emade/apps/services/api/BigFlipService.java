package com.emade.apps.services.api;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;

public interface BigFlipService {
  Disbursement disbursement(DisbursementRequest request);
}
