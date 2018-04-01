package com.kishore.dynamicworkflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.dynamicworkflow.model.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long>{

}
