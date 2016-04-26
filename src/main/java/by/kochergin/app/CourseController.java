package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Course;
import by.kochergin.app.service.CourseService;

@RestController

public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping("/course")
	public @ResponseBody List<Course> getCourses() {
		return courseService.getCourses();
	}
}
