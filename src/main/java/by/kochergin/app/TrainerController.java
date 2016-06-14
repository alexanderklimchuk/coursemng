package by.kochergin.app;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Trainer;
import by.kochergin.app.service.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	TrainerService trainerService;

	@RequestMapping(value = "/trainer", method = RequestMethod.GET)
	public @ResponseBody List<Trainer> getCourses() {
		return trainerService.getAll();
	}

	@RequestMapping(value = "/trainer", method = RequestMethod.POST)
	public @ResponseBody Trainer create(@RequestBody Trainer trainer) {
		return trainerService.create(trainer);
	}
	
	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.PUT)
	public @ResponseBody Trainer update(@RequestBody Trainer trainer) {
		return trainerService.update(trainer);
	}

	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.GET)
	public @ResponseBody Trainer get(@PathVariable("id") Integer id) {
		return trainerService.get(id);
	}

	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		trainerService.delete(id);
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
