package by.kochergin.app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import by.kochergin.app.domain.Attendency;
import by.kochergin.app.domain.Child;
import by.kochergin.app.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	private ChildService service;

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public @ResponseBody List<Child> getAll(@QueryParam(value = "courseId") Integer courseId) {
		return service.getAll();
	}

	@RequestMapping(value = "/child", method = RequestMethod.POST)
	public @ResponseBody Child create(@RequestBody Child child) {
		return service.create(child);
	}

	@RequestMapping(value = "/child/{id}/photo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void create(@RequestParam("file") MultipartFile file, @PathParam("id") Integer childId) {
		if (service.get(childId) != null) {

		} else {
			throw new RuntimeException("Child with id = " + childId + " is not specified");
		}
	}

	@RequestMapping(value = "/child/{id}", method = RequestMethod.PUT)
	public @ResponseBody Child update(@RequestBody Child child) {
		return service.update(child);
	}

	@RequestMapping(value = "/child/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		service.delete(id);
		service.delete(id);
	}

	@RequestMapping(value = "/child/{id}", method = RequestMethod.GET)
	public @ResponseBody Child get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
	
	@RequestMapping(value = "/child/{id}/attendencies", method = RequestMethod.GET)
	public @ResponseBody List<Attendency> getChildAttendencies(@PathVariable("id") Integer id) {
		return new ArrayList(service.get(id).getAttendencies());
	}
	
	@RequestMapping(value = "/child/{id}/payments", method = RequestMethod.GET)
	public @ResponseBody List<Attendency> getChildPayments(@PathVariable("id") Integer id) {
		return new ArrayList(service.get(id).getPayments());
	}
}