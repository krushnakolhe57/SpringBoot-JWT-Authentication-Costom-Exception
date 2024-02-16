package com.sb.repository;

import org.springframework.data.repository.CrudRepository;
import com.sb.entity.User;
import java.util.List;
import java.util.Optional;

import com.sb.entity.Company;
import com.sb.entity.Role;





public interface UserRepository  extends CrudRepository<User, Integer>{
	
	public User findById(int id);
	
	Optional<User> findByNameOrMail(String name, String mail);

	public List<User> findByCompany(Company company);
	
	List<User> findByRoles(Role roles);

	

}
