package com.emade.apps.services.api;

import com.emade.apps.dto.entity.Disbursement;
import com.emade.apps.dto.request.DisbursementRequest;
import java.math.BigInteger;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.server.ResponseStatusException;

public interface DisburseService {
  @Retryable(value = ResponseStatusException.class, maxAttempts = 5, backoff = @Backoff(delay = 1000))
  Boolean saveDisbursement(DisbursementRequest request);

  @Retryable(value = ResponseStatusException.class, maxAttempts = 5, backoff = @Backoff(delay = 1000))
  Disbursement getDisbursementStatus(BigInteger id);
}
