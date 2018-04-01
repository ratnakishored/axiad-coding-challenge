package com.kishore.dynamicworkflow.service;

import java.util.List;

import com.kishore.dynamicworkflow.bean.WorkflowBean;

public interface WorkflowService {
	
	List<WorkflowBean> getAllWorkflows();
	
	void createWorkflow(WorkflowBean workflowBean);

}
