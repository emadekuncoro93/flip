package com.emade.apps.services.api;

public interface DisburseService {
  Boolean saveDisbursement(Object request);
  Object getDisbursementStatus(Integer id);
}
