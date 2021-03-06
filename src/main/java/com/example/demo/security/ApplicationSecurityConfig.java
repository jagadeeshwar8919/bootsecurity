package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/","index","/css/*","/js/*")
		    .permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails jaiuser=User.builder()
				                     .username("jagadeesh")
				                      .password(passwordEncoder.encode("Jaga@9951"))
				                       .roles(ApplicationUserRoles.STUDENT.name()).build();
		UserDetails virajuser=User.builder()
				.username("viraj")
				.password(passwordEncoder.encode("viraj@8919"))
				.roles(ApplicationUserRoles.ADMIN.name())
				.build();

		return new InMemoryUserDetailsManager(
				jaiuser,virajuser
		);
	}
}
