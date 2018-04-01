package com.kishore.dynamicworkflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.dynamicworkflow.model.WorkflowStep;

@Repository
public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Long> {

}
