package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Child;
import by.kochergin.app.domain.Parent;
import by.kochergin.app.service.ParentService;

@RestController

public class ParentController {

	@Autowired
	ParentService parentService;

	@RequestMapping("/parent")
	public @ResponseBody List<Parent> getCourses() {
		return parentService.getAll();
	}

	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	public @ResponseBody Parent create(@RequestBody Parent parent) {
		return parentService.create(parent);
	}

	@RequestMapping(value = "/parent/{id}", method = RequestMethod.PUT)
	public @ResponseBody Parent update(@RequestBody Parent parent) {
		return parentService.update(parent);
	}

	@RequestMapping(value = "/parent/{id}", method = RequestMethod.GET)
	public @ResponseBody Parent get(@PathVariable("id") Integer id) {
		return parentService.get(id);
	}
	
	
	@RequestMapping(value = "/parent/{id}/children", method = RequestMethod.GET)
	public @ResponseBody List<Child> getChildren(@PathVariable("id") Integer id) {
		return parentService.getChildren(id);
	}

	@RequestMapping(value = "/parent/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		parentService.delete(id);
	}
}
