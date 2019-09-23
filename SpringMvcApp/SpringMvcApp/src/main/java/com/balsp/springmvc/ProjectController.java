package com.balsp.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@RequestMapping("/project")
	public ModelAndView showPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project");
		return mv;		
	}
	
	@RequestMapping(value="/Save", method=RequestMethod.POST )
	public ModelAndView saveProject(Project proj) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProjectDao dao = (ProjectDao)ctx.getBean("pdao");
		
		int status = dao.saveProject(proj);
		if(status>0) {
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

}
