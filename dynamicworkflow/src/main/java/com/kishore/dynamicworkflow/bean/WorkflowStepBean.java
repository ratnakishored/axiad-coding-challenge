package com.kishore.dynamicworkflow.bean;

import java.io.Serializable;

public class WorkflowStepBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long workflowStepId;
	
	private String name;
	
	private String description;
	
	private Integer order;
	
	private Long workflowId;
	
	private Long userId;

	public Long getWorkflowStepId() {
		return workflowStepId;
	}

	public void setWorkflowStepId(Long workflowStepId) {
		this.workflowStepId = workflowStepId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
