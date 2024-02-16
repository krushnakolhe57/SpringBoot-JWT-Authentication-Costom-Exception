package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.Company;
import com.sb.entity.User;
import com.sb.repository.CompanyRepository;
import com.sb.repository.UserRepository;

@Service
public class UserService  {   //   implements UserDetailsService

		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private CompanyRepository companyRepository;
		
		
		/*
		 * @Override public UserDetails loadUserByUsername(String username) throws
		 * UsernameNotFoundException {
		 * 
		 * User user = userRepository.findByNameOrMail(username, username)
		 * .orElseThrow( () -> new UsernameNotFoundException("Username Not Found") );
		 * 
		 * Set<GrantedAuthority> authority = user.getRoles().stream() .map( role -> new
		 * SimpleGrantedAuthority(role.getRole())) .collect(Collectors.toSet());
		 * 
		 * 
		 * 
		 * return new User(username, user.getPassword(), authority); }
		 */
		
		
			
			
	
		public List<User> getAllUsers(){
			return (List<User> ) userRepository.findAll();
		}
		
		
		
		
		public User getById(int id) {
			
			return userRepository.findById(id);
		}
		
		
		public User  addUser(User u)  {
			return userRepository.save(u);
		}
		
		
		
		public void deleteByid(int id) {
		
			userRepository.deleteById(id);
		}
	
		
		
		
		
		
		public List<User> getByCompany(Integer company_id){
			
			Company company = this.companyRepository.findById(company_id)
													.orElseThrow(() -> new RuntimeException("Not Get Company_Id"));
			
			
			return this.userRepository.findByCompany(company);
			
		}
		

		
		public void updateUser(   User user , Integer id) {
			
			user.setId(id);
			userRepository.save(user);
		}



}
