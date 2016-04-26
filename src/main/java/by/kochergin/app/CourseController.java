package by.kochergin.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Course;

@RestController


public class CourseController {

	@RequestMapping("/course")
	public @ResponseBody List<Course> getCourses() {
		return new ArrayList<Course>();
	}
}
