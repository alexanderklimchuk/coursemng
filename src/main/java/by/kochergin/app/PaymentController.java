package by.kochergin.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kochergin.app.domain.Payment;
import by.kochergin.app.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService service;

	@RequestMapping("/payment")
	public @ResponseBody List<Payment> getPayments() {
		return service.getAll();
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public @ResponseBody Payment create(@RequestBody Payment payment) {
		return service.create(payment);
	}

	@RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}