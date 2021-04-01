package com.emade.apps.services.api;

import com.emade.apps.dto.request.DisbursementRequest;

public interface DisburseService {
  Boolean saveDisbursement(DisbursementRequest request);
  Object getDisbursementStatus(Integer id);
}
