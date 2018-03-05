package com.hobbyProject.mahs.repository;

import com.hobbyProject.mahs.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
    
}
