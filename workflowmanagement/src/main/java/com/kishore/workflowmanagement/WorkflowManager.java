package com.kishore.workflowmanagement;

public class WorkflowManager {
	
	public static Workflow createWorkflow(String name, String description) {
		Workflow workflow = null;
		if (name != null) {
			workflow = new Workflow();
			workflow.setName(name);
			workflow.setDescription(description);
		}
		return workflow;
	}
	
	public static boolean addWorkflowStep(Workflow workflow, Step step) {
		boolean success = false;
		if (workflow != null && step != null) {
			workflow.getSteps().add(step);
			success = true;
		}
		return success;
	}
	
	public static boolean addWorkflowStepBefore(Workflow workflow, Step beforeStep, Step currentStep) {
		boolean success = false;
		
		if (workflow != null && currentStep != null) {
			if (beforeStep != null) {
				int index = workflow.getSteps().indexOf(beforeStep);
				if (index >= 0) {
					workflow.getSteps().add(index, currentStep);
					success = true;
				}
			}
		}
		
		return success;
		
	}
	
	public static boolean addWorkflowStepAfter(Workflow workflow, Step afterStep, Step currentStep) {
		boolean success = false;
		
		if (workflow != null && currentStep != null) {
			if (afterStep != null) {
				int index = workflow.getSteps().indexOf(afterStep);
				if (index >= 0) {
					workflow.getSteps().add(index + 1, currentStep);
					success = true;
				}
			}
		}
		
		return success;
	}
	

}
