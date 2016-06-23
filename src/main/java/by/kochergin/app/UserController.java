package by.kochergin.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.kochergin.app.domain.User;
import by.kochergin.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/userobj", method = RequestMethod.GET)
	@ResponseBody
	public User currentUserName(Authentication authentication) {
		return userservice.getUserByName(authentication.getName());
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response,
			// auth);
			SecurityContextHolder.clearContext();
			request.getSession().invalidate();
		}
		return "redirect:/index.html";// You can redirect wherever you want, but
										// generally it's a good practice to
										// show login screen again.
	}
}