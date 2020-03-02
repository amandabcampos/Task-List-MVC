package co.grandcircus.tasklist.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.tasklist.dao.TaskRepository;
import co.grandcircus.tasklist.dao.UserRepository;
import co.grandcircus.tasklist.entity.Task;
import co.grandcircus.tasklist.entity.User;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("user/{id}/task/add") 
	public ModelAndView addTask(@PathVariable("id") User user) {
		return new ModelAndView("task-add", "user", user); 
	}
	
	@PostMapping("user/{id}/task/add") 
	public ModelAndView addTask(@RequestParam("description") String description,
			@RequestParam("dueDate") String dueDate,
			@RequestParam("completion") Boolean completion,
			@RequestParam("userId") Long userId,
			@RequestParam("email") String email) throws ParseException {
		Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dueDate); 
		
		Task task = new Task();
		task.setDescription(description);
		task.setCompletion(completion);
		task.setDueDate(date);
		task.setUser(userRepo.findByEmail(email));
		taskRepo.save(task);
		
		ModelAndView mav = new ModelAndView("redirect:/user/"+userId);
		return mav;
	}
	
	@RequestMapping("user/{userid}/task/{taskid}/editcompletion")
	public ModelAndView editCompletion(@PathVariable("taskid") Task task) {
		if (task.isCompletion()) {
			task.setCompletion(false);
		} else {
			task.setCompletion(true);
		}
		taskRepo.save(task);
		return new ModelAndView("redirect:/user/{userid}");  
	}

	@RequestMapping("user/{userid}/task/{taskid}/delete") 
	public ModelAndView delete(@PathVariable("taskid") Task task) {
		taskRepo.delete(task);
		return new ModelAndView("redirect:/user/{userid}");  
	}
	
	@RequestMapping("user/{userid}/search")
	public ModelAndView search(@PathVariable("userid") User user,
			@RequestParam("description") String description) {
		List<Task> tasks = taskRepo.findByDescriptionContainingIgnoreCase(description);
		ModelAndView mav = new ModelAndView("task-search");
		mav.addObject("user", user);
		mav.addObject("tasks", tasks);
		return mav;
	}
	
	
	

}
