package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return trainerService.getTrainers();
	}
	
	@RequestMapping(value = "/trainer", method = RequestMethod.POST)
	public @ResponseBody Trainer create(@RequestBody Trainer trainer) {
		return trainerService.create(trainer);
	}

}
