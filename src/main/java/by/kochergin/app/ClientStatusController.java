package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Clientstatus;
import by.kochergin.app.service.ClientStatusService;

@RestController

public class ClientStatusController {

	@Autowired
	ClientStatusService statusService;

	@RequestMapping("/clientstatus")
	public @ResponseBody List<Clientstatus> getStatuses() {
		return statusService.getAll();
	}

	@RequestMapping(value = "/clientstatus", method = RequestMethod.POST)
	public @ResponseBody Clientstatus create(@RequestBody Clientstatus status) {
		return statusService.create(status);
	}

	@RequestMapping(value = "/clientstatus/{id}", method = RequestMethod.PUT)
	public @ResponseBody Clientstatus update(@RequestBody Clientstatus status) {
		return statusService.update(status);
	}

	@RequestMapping(value = "/clientstatus/{id}", method = RequestMethod.GET)
	public @ResponseBody Clientstatus get(@PathVariable("id") Integer id) {
		return statusService.get(id);
	}

	@RequestMapping(value = "/clientstatus/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		statusService.delete(id);
	}
}
