package com.kishore.workflowmanagement;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
	
	private String name;
	
	private String description;
	
	private List<Step> steps;
	
	public Workflow() {
		steps = new ArrayList<>();
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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
}
