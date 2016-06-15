package by.kochergin.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login,password,isActve from user where login=?")
				.authoritiesByUsernameQuery("select login, role from user where login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.httpBasic().and().authorizeRequests().antMatchers("/").access(
		 * "hasRole('ROLE_ADMIN')").anyRequest().permitAll().and().formLogin().
		 * loginPage("/login").usernameParameter("username")
		 * .passwordParameter("password").and().logout().logoutSuccessUrl(
		 * "/login?logout").and().exceptionHandling().accessDeniedPage("/403").
		 * and().csrf();
		 */

		// http.httpBasic().and().authorizeRequests().antMatchers("/index.html",
		// "/home.html", "/login.html", "/",
		// "/**").permitAll().anyRequest().authenticated().and().csrf()
		// .csrfTokenRepository(csrfTokenRepository()).and().addFilterAfter(csrfHeaderFilter(),
		// CsrfFilter.class);

		http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/home.html", "/login.html", "/", "/**").authenticated().and().csrf()
				.csrfTokenRepository(csrfTokenRepository()).and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
	}

	private Filter csrfHeaderFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
				CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
				if (csrf != null) {
					Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
					String token = csrf.getToken();
					if (cookie == null || token != null && !token.equals(cookie.getValue())) {
						cookie = new Cookie("XSRF-TOKEN", token);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
				filterChain.doFilter(request, response);
			}
		};
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

}
// access("hasRole('admin')").anyRequest()
// authorizeRequests()
// .antMatchers("/index.html", "/home.html", "/login.html",
// "/").permitAll().anyRequest()
// .authenticated().1
