package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.kochergin.app.domain.Attendency;
import by.kochergin.app.service.AttendencyService;

@Controller
public class AttendecyController {
	@Autowired
	private AttendencyService service;
	
	@RequestMapping("/attendency")
	public @ResponseBody List<Attendency> getAttendecies() {
		return service.getAll();
	}

	@RequestMapping(value = "/attendency", method = RequestMethod.POST)
	public @ResponseBody Attendency create(@RequestBody Attendency attendency) {
		return service.create(attendency);
	}

	@RequestMapping(value = "/attendency/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

}
