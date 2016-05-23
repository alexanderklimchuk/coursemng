package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Discountcard;
import by.kochergin.app.service.DiscountcardService;

@RestController
public class DicountCardController {

	@Autowired
	private DiscountcardService service;

	@RequestMapping("/discountCard")
	public @ResponseBody List<Discountcard> getCourses() {
		return service.getAll();
	}

	@RequestMapping(value = "/discountCard", method = RequestMethod.POST)
	public @ResponseBody Discountcard create(@RequestBody Discountcard card) {
		return service.create(card);
	}

	@RequestMapping(value = "/discountCard/{id}", method = RequestMethod.PUT)
	public @ResponseBody Discountcard update(@RequestBody Discountcard card) {
		return service.update(card);
	}

	@RequestMapping(value = "/discountCard/{id}", method = RequestMethod.GET)
	public @ResponseBody Discountcard get(@PathVariable("id") Integer id) {
		return service.get(id);
	}

	@RequestMapping(value = "/discountCard/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

}
