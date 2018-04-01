package com.kishore.dynamicworkflow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dynamicworkflow.bean.WorkflowBean;
import com.kishore.dynamicworkflow.model.Workflow;
import com.kishore.dynamicworkflow.repository.WorkflowRepository;
import com.kishore.dynamicworkflow.service.WorkflowService;

@Service
@Transactional
public class WorkflowServiceImpl implements WorkflowService {
	
	@Autowired
	private WorkflowRepository workflowRepository;

	@Override
	public void createWorkflow(WorkflowBean workflowBean) {
		Workflow workflow = new Workflow();
		workflow.setName(workflowBean.getName());
		workflow.setDescription(workflowBean.getDescription());
		workflowRepository.save(workflow);
	}

	@Override
	public List<WorkflowBean> getAllWorkflows() {
		List<WorkflowBean> workflowBeanList = new ArrayList<>();
		
		List<Workflow> workflowList = workflowRepository.findAll();
		if (workflowList != null) {
			workflowList.forEach(workflow -> {
				WorkflowBean workflowBean = new WorkflowBean();
				workflowBean.setWorkflowId(workflow.getId());
				workflowBean.setName(workflow.getName());
				
				workflowBeanList.add(workflowBean);
			});
		}
		
		return workflowBeanList;
	}

}
