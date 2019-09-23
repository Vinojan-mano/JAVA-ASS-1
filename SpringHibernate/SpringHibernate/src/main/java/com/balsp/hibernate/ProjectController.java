package com.balsp.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	@RequestMapping("/project")
	public ModelAndView showPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project");
		return mv;		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST )
	public ModelAndView saveProject(Project proj) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProjectDao dao = (ProjectDao)ctx.getBean("pdao");
		
		if(dao.saveProject(proj)) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("failed");
			return mv;
		}		
		
	}
	
	@RequestMapping(value="/view", method=RequestMethod.POST )
	public ModelAndView sendObject() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view");
		
		ProjectDao dao = (ProjectDao)ctx.getBean("pdao");		
		List<Project> projects = dao.getProjects();		
		modelAndView.addObject("Projects", projects);
		return modelAndView;	
	}
}
