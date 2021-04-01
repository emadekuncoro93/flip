package com.emade.apps.repositories.api;

import com.emade.apps.dto.entity.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisbursementRepository extends JpaRepository<Disbursement, Integer> {

}
