package com.kishore.dynamicworkflow.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kishore.dynamicworkflow.bean.WorkflowBean;
import com.kishore.dynamicworkflow.service.WorkflowService;

@Controller
public class WorkflowController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WorkflowService workflowService;
	
	public WorkflowController() {
		
	}
	
	@GetMapping("workflow")
	public ModelAndView createWorkflowView(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("workflow", new WorkflowBean());
		modelAndView.setViewName("workflow");
		return modelAndView;
	}
	
	@PostMapping("createWorkflow")
	public String createWorkflow(WorkflowBean workflowBean) {
		workflowService.createWorkflow(workflowBean);

		return "redirect:/";
	}

}
