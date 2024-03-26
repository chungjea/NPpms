package com.web.spring.controller.hcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.web.spring.service.hcj.GanttService;
import com.web.spring.vo.TaskRink_f;
import com.web.spring.vo.Task_f;

@Controller
public class GanttController {

	@Autowired(required = false)
	private GanttService ganttservice;
	
	@RequestMapping("Taskdata")
	public ModelAndView taskdata( int pcode) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("data", ganttservice.getTaskdatas(pcode));
		modelAndView.addObject("links", ganttservice.getRink(pcode));
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "insertTask", method = RequestMethod.POST)
	public ModelAndView insertTask(@RequestBody Task_f ins) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", ganttservice.insertTask(ins));
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "updateTask", method = RequestMethod.POST)
	public ModelAndView updateTask(@RequestBody Task_f upt) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", ganttservice.updateTask(upt));

		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "deleteTask", method = RequestMethod.POST)
	public ModelAndView deleteTask(@RequestBody Task_f del) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", ganttservice.deleteTask(del));
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "deleteChildTask", method = RequestMethod.POST)
	public ModelAndView deleteChildTask(@RequestBody Task_f cdel) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", ganttservice.deleteAllChildTask(cdel));
		return modelAndView;
	}
	
	
	@ResponseBody
	@PostMapping("insertLink")
	public ResponseEntity<?> insertTaskLink(@RequestBody TaskRink_f ins){
		return ResponseEntity.ok(ganttservice.insertRink(ins));
	}
	
	@ResponseBody
	@PostMapping("deleteLink")
	public ResponseEntity<?> deleteTaskLink(@RequestBody TaskRink_f del){
		return ResponseEntity.ok(ganttservice.deleteLink(del));
	}
}
