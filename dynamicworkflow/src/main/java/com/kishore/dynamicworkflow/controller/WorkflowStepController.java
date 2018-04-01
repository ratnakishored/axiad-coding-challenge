package com.kishore.dynamicworkflow.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kishore.dynamicworkflow.bean.UserBean;
import com.kishore.dynamicworkflow.bean.WorkflowBean;
import com.kishore.dynamicworkflow.bean.WorkflowStepBean;
import com.kishore.dynamicworkflow.service.UserService;
import com.kishore.dynamicworkflow.service.WorkflowService;
import com.kishore.dynamicworkflow.service.WorkflowStepService;

@Controller
public class WorkflowStepController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private WorkflowStepService workflowStepService;
	
	public WorkflowStepController() {
		
	}
	
	@GetMapping("workflowStep")
	public ModelAndView createWorkflowStepView(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("workflowStep", new WorkflowStepBean());
		modelAndView.addObject("allWorkflows", getAllWorkflows());
		modelAndView.addObject("allUsers", getAllUsers());
		modelAndView.setViewName("workflowStep");
		return modelAndView;
	}
	
	@PostMapping("createWorkflowStep")
	public String createWorkflowStep(WorkflowStepBean workflowStepBean) {
		workflowStepService.createWorkflowStep(workflowStepBean);
		return "redirect:/";
	}
	
	public List<WorkflowBean> getAllWorkflows() {
		return workflowService.getAllWorkflows();
	}
	
	public List<UserBean> getAllUsers() {
		return userService.getAllUsers();
	}

}
