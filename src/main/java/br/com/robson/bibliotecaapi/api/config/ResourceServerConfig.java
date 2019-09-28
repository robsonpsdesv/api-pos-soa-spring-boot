package br.com.robson.bibliotecaapi.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourceServerConfig 
				extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"/swagger-ui.html",
				"/webjars/**",
				"/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.csrf().disable();
	}
	
	@Override
	public void configure(
			ResourceServerSecurityConfigurer resources) 
					throws Exception {
		resources.stateless(true);
	}
}
