package com.emade.apps.repositories.api;

import com.emade.apps.dto.entity.Disbursement;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementRepository extends JpaRepository<Disbursement, Integer> {
  Disbursement findFirstById(BigInteger id);
}
