package com.sb.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableMethodSecurity
public class JwtSecurityConfig  implements ApplicationContextAware {
	
	
	@Autowired
	private JwtAuthenticationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;


   
		    @Bean
		    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		        http
		                .csrf(csrf -> csrf.disable())
		                .authorizeHttpRequests(  (auth)  ->      auth
		                																			.requestMatchers("/normal/**" ).hasRole("NORMAL")
		                																				.requestMatchers("/admin/**" ).hasRole("ADMIN")
		                																				.requestMatchers("/public/**" , "/auth/login" ).permitAll()
		                																				.anyRequest()
		                																				.authenticated()
		                																				)
		                .exceptionHandling( ex -> ex.authenticationEntryPoint(point))
		                .sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));     
		        
		        http.addFilterBefore(filter,  UsernamePasswordAuthenticationFilter.class);
		        
		        return http.build();
		    }
		    
		    
		    
		    @Bean
		    PasswordEncoder passwordEncoder() {
				    return new BCryptPasswordEncoder();
				}
		    

		    @Bean
		     AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		    	
				return configuration.getAuthenticationManager();
		    }
		    
		    
		    @Bean
			  UserDetailsService userDetailsService() {
			    
			    	
			    	UserDetails normalUser =
			    			 User.builder().
			                 username("user")       //    .builder()	.username("user")
			    		.password(passwordEncoder().encode("1234"))
			    		.roles("NORMAL")
			    		.build();
			    	
			    	UserDetails adminUser =
			    			 User.builder().
			                 username("krish")
			    	    		.password(passwordEncoder().encode("1234567"))
			    	    		.roles("ADMIN")
			    	    		.build();
			    	
				return new InMemoryUserDetailsManager(normalUser , adminUser);
				
			  }
		    
//		    @Autowired
//		    public void setJwtAuthenticationFilter(JwtAuthenticationFilter filter) {
//		        this.filter = filter;
//		    }
		    


			@Override
			public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
				  this.filter = applicationContext.getBean(JwtAuthenticationFilter.class);
				
			}
}
