package com.kishore.workflowmanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kishore.workflowmanagement.Step;
import com.kishore.workflowmanagement.StepManager;
import com.kishore.workflowmanagement.Workflow;
import com.kishore.workflowmanagement.WorkflowManager;

public class WorkflowManagerTest {

	@Test
	public void testCreateWorkflowWithNullInput() {
		Workflow workflow = WorkflowManager.createWorkflow(null, null);
		assertNull(workflow);
	}
	
	@Test
	public void testCreateWorkflowWithVaildInput() {
		String name = "Passport Office";
		String desc = "Passport Office";
		
		Workflow workflow = WorkflowManager.createWorkflow(name, desc);
		assertNotNull(workflow);
		assertEquals(name, workflow.getName());
		assertEquals(desc, workflow.getDescription());
	}

	@Test
	public void testAddWorkflowStepWithNullWorkflow() {
		Step step = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(step);
		
		Workflow workflow = null;
		boolean result = WorkflowManager.addWorkflowStep(workflow, step);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepWithNullStep() {
		Step step = null;
		Workflow workflow = WorkflowManager.createWorkflow("Passport Office", "Passport Office Desc");
		assertNotNull(workflow);

		boolean result = WorkflowManager.addWorkflowStep(workflow, step);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStep() {
		Workflow workflow = createWorkflow();

		Step step = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(step);
		
		boolean result = WorkflowManager.addWorkflowStep(workflow, step);
		assertTrue(result);
		
		assertEquals(1, workflow.getSteps().size());
	}

	@Test
	public void testAddWorkflowStepBeforeWithNullWorkflow() {
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		Workflow workflow = null;
		boolean result = WorkflowManager.addWorkflowStepBefore(workflow, null, step);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepBeforeWithNullCurrentStep() {
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		Workflow workflow = null;
		boolean result = WorkflowManager.addWorkflowStepBefore(workflow, step, null);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepBeforeWithNullBeforeStep() {
		Workflow workflow = createWorkflow();
		
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		boolean result = WorkflowManager.addWorkflowStepBefore(workflow, null, step);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepBeforeWithBeforeStepNotExists() {
		Workflow workflow = createWorkflow();
		
		Step submitStep = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(submitStep);
		
		Step biometricStep = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(biometricStep);
		
		assertTrue(WorkflowManager.addWorkflowStep(workflow, submitStep));
		assertTrue(WorkflowManager.addWorkflowStep(workflow, biometricStep));

		
		Step dummyBeforeStep = StepManager.createStep("Dummy", "Dummy Desc");
		assertNotNull(dummyBeforeStep);
		
		Step stepToAdd = StepManager.createStep("Verify Applciation", "Verify Applciation Desc");
		assertNotNull(stepToAdd);
		
		
		boolean result = WorkflowManager.addWorkflowStepBefore(workflow, dummyBeforeStep, stepToAdd);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepBeforeWithBeforeStepExists() {
		Workflow workflow = createWorkflow();
		
		Step submitStep = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(submitStep);
		
		Step biometricStep = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(biometricStep);
		
		assertTrue(WorkflowManager.addWorkflowStep(workflow, submitStep));
		assertTrue(WorkflowManager.addWorkflowStep(workflow, biometricStep));

		Step stepToAdd = StepManager.createStep("Verify Applciation", "Verify Applciation Desc");
		assertNotNull(stepToAdd);
		
		boolean result = WorkflowManager.addWorkflowStepBefore(workflow, biometricStep, stepToAdd);
		assertTrue(result);
		
		assertEquals(1, workflow.getSteps().indexOf(stepToAdd));
		
//		workflow.getSteps().forEach(step -> System.out.println(step.getName()));
	}

	@Test
	public void testAddWorkflowStepAfterWithNullWorkflow() {
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		Workflow workflow = null;
		boolean result = WorkflowManager.addWorkflowStepAfter(workflow, null, step);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepAfterWithNullCurrentStep() {
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		Workflow workflow = null;
		boolean result = WorkflowManager.addWorkflowStepAfter(workflow, step, null);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepAfterWithNullAfterStep() {
		Workflow workflow = createWorkflow();
		
		Step step = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(step);
		
		boolean result = WorkflowManager.addWorkflowStepAfter(workflow, null, step);
		assertFalse(result);
	}

	@Test
	public void testAddWorkflowStepAfterWithAfterStepNotExists() {
		Workflow workflow = createWorkflow();
		
		Step submitStep = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(submitStep);
		
		Step biometricStep = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(biometricStep);
		
		assertTrue(WorkflowManager.addWorkflowStep(workflow, submitStep));
		assertTrue(WorkflowManager.addWorkflowStep(workflow, biometricStep));

		
		Step dummyAfterStep = StepManager.createStep("Dummy", "Dummy Desc");
		assertNotNull(dummyAfterStep);
		
		Step stepToAdd = StepManager.createStep("Verify Applciation", "Verify Applciation Desc");
		assertNotNull(stepToAdd);
		
		
		boolean result = WorkflowManager.addWorkflowStepAfter(workflow, dummyAfterStep, stepToAdd);
		assertFalse(result);
	}
	
	@Test
	public void testAddWorkflowStepAfterWithAfterStepExists() {
		Workflow workflow = createWorkflow();
		
		Step submitStep = StepManager.createStep("Submit Application", "Submit Application");
		assertNotNull(submitStep);
		
		Step biometricStep = StepManager.createStep("Biometric Collection", "Biometric Collection Desc");
		assertNotNull(biometricStep);
		
		assertTrue(WorkflowManager.addWorkflowStep(workflow, submitStep));
		assertTrue(WorkflowManager.addWorkflowStep(workflow, biometricStep));

		Step stepToAdd = StepManager.createStep("Verify Applciation", "Verify Applciation Desc");
		assertNotNull(stepToAdd);
		
		boolean result = WorkflowManager.addWorkflowStepAfter(workflow, submitStep, stepToAdd);
		assertTrue(result);
		
		assertEquals(1, workflow.getSteps().indexOf(stepToAdd));
		
//		workflow.getSteps().forEach(step -> System.out.println(step.getName()));
	}
	
	private Workflow createWorkflow() {
		Workflow workflow = WorkflowManager.createWorkflow("Passport Office", "Passport Office Desc");
		assertNotNull(workflow);
		return workflow;
	}
	


}
