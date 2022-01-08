package com.example.demotywatoryv2.repository;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemotywatorEntityRepository extends JpaRepository<DemotywatorEntity, Long>{

}
