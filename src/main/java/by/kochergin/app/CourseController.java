package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Course;
import by.kochergin.app.domain.Trainer;
import by.kochergin.app.service.CourseService;

@RestController

public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public @ResponseBody List<Course> getCourses() {
		return courseService.getAll();
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public @ResponseBody Course create(@RequestBody Course course) {
		return courseService.create(course);
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
	public @ResponseBody Course update(@RequestBody Course course) {
		return courseService.update(course);
	}

	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public @ResponseBody Course get(@PathVariable("id") Integer id) {
		return courseService.get(id);
	}

	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		courseService.delete(id);
	}
}
