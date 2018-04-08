package com.kishore.workflowmanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kishore.workflowmanagement.Step;
import com.kishore.workflowmanagement.StepManager;

public class StepManagerTest {

	@Test
	public void testCreateStepWithNullInput() {
		Step step = StepManager.createStep(null, null);
		assertNull(step);
	}
	
	@Test
	public void testCreateStepWithValidInput() {
		String name = "Submit Application";
		String desc = "Submit Application Description";
		Step step = StepManager.createStep(name, desc);
		assertNotNull(step);
		assertEquals(name, step.getName());
		assertEquals(desc, step.getDescription());
	}

}
