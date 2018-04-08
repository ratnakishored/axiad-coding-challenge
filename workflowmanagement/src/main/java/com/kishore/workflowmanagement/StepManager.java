package com.kishore.workflowmanagement;

public class StepManager {
	
	public static Step createStep(String name, String description) {
		Step step = null;
		if (name != null) {
			step = new Step();
			step.setName(name);
			step.setDescription(description);
		}
		return step;
	}

}
