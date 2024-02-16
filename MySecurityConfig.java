//package com.sb.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//
//@Configuration
//@EnableMethodSecurity
//public class MySecurityConfig  {
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint point;
//	
//	@Autowired
//	private JwtAuthenticationFilter filter;
//
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//		    return new BCryptPasswordEncoder();
//		}
//		    @Bean
//		    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		        http
//		                .csrf(csrf -> csrf.disable())
//		                .authorizeHttpRequests(  (auth)  ->      auth  
//		                																			.requestMatchers("/normal/**" ).hasRole("NORMAL")
//		                																				.requestMatchers("/admin/**" ).hasRole("ADMIN")
//		                																				.requestMatchers("/public/**" ).permitAll()
//		                																				.anyRequest()
//		                																				.authenticated()
//		                																				)
//		                .formLogin(login -> login  //  .loginPage("/login")
//		                										 //  .loginProcessingUrl("/login")
//		                									//	.defaultSuccessUrl("/welcome")
//		                											.permitAll()   )
//		                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		                											.permitAll()   )
//		                ;       
//		        
//			        return http.build();
//			    }
//		    
//		    
//
//		    @Bean
//		     AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		    	
//				return configuration.getAuthenticationManager();
//		    }
////		    
//		    
//		    
////		    
//		    @Bean
//		  UserDetailsService userDetailsService() {
//		    
//		    	
//		    	UserDetails normalUser =
//		    	User
//		    		.withUsername("user")       //    .builder()	.username("user")
//		    		.password(passwordEncoder().encode("1234"))
//		    		.roles("NORMAL")
//		    		.build();
//		    	
//		    	UserDetails adminUser =
//		    	    	User
//		    	    		.withUsername("krish")
//		    	    		.password(passwordEncoder().encode("1234567"))
//		    	    		.roles("ADMIN")
//		    	    		.build();
//		    	
//			return new InMemoryUserDetailsManager(normalUser , adminUser);
//			
//		  }
//
//}