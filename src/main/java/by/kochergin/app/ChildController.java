package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Child;
import by.kochergin.app.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	private ChildService service;

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public @ResponseBody List<Child> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/child", method = RequestMethod.POST)
	public @ResponseBody Child create(Child child) {
		return service.create(child);
	}

	@RequestMapping(value = "/child", method = RequestMethod.PUT)
	public @ResponseBody Child update(Child child) {
		return service.update(child);
	}

	@RequestMapping(value = "/child/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@RequestParam Integer id) {
		service.delete(id);
	}
}
