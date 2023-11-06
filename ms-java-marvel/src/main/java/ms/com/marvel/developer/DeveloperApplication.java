package ms.com.marvel.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.reactive.function.client.WebClient;

import com.marvel.developer.ConectorMarvelAPI;

import ms.com.marvel.developer.security.JWTAuthorizationFilter;

@SpringBootApplication
public class DeveloperApplication {
	@Bean
	public WebClient getWebClientBuilder(){
		return WebClient.create();
	}
	
	@Bean
	public ConectorMarvelAPI getConectorMarvelAPI(){
		return new ConectorMarvelAPI();
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.anyRequest().authenticated();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DeveloperApplication.class, args);
	}

}
