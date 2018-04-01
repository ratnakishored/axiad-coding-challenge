package com.kishore.dynamicworkflow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dynamicworkflow.bean.WorkflowStepBean;
import com.kishore.dynamicworkflow.model.WorkflowStep;
import com.kishore.dynamicworkflow.repository.UserRepository;
import com.kishore.dynamicworkflow.repository.WorkflowRepository;
import com.kishore.dynamicworkflow.repository.WorkflowStepRepository;
import com.kishore.dynamicworkflow.service.WorkflowStepService;

@Service
@Transactional
public class WorkflowStepServiceImpl implements WorkflowStepService {
	
	@Autowired
	private WorkflowStepRepository workflowStepRepository;
	
	@Autowired
	private WorkflowRepository workflowRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createWorkflowStep(WorkflowStepBean workflowStepBean) {
		WorkflowStep workflowStep = new WorkflowStep();
		workflowStep.setName(workflowStepBean.getName());
		workflowStep.setDescription(workflowStepBean.getDescription());
		workflowStep.setUser(userRepository.findById(workflowStepBean.getUserId()).get());
		workflowStep.setWorkflow(workflowRepository.findById(workflowStepBean.getWorkflowId()).get());
		workflowStepRepository.save(workflowStep);
	}

}
