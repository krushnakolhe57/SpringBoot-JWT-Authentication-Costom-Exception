package com.sb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.converter.UserConverter;
import com.sb.entity.User;
import com.sb.entity.UserDto;
import com.sb.exception.UserException;
import com.sb.exception.UserException2;
import com.sb.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {
	
@Autowired
	private UserService userservice;

@Autowired
	private UserConverter converter;



	public UserController( UserService userservice) {

		this.userservice = userservice;
	}



	@GetMapping ("/users")
	public  List<UserDto> getAllUsers() throws UserException {
		
		List<User> list = this.userservice.getAllUsers();
		
		List<UserDto> dto = this.converter.userToDto(list);
		
		if(dto.size() <= 0) {
			throw new UserException("No Users here !!");
		}
		
		return dto;
	}
	
	
	
	@GetMapping ("/user/{id}")
	public UserDto getById(@PathVariable ("id")  int id) throws UserException2{
		
		User user  =  this.userservice.getById(id);
		
		if(user == null) {
			throw new UserException2("No Users Found !!");
		}
		
		UserDto dto = this.converter.userToDto(user);
		 
		
			return dto;
	}

	
	@PostMapping ("/adduser")
	public String addUser (@RequestBody User user) throws UserException {
		
		User u = this.userservice.addUser(user);
	

			if((u.getName() == null) || ( u.getName().equals("")) ) {
				throw new UserException("Name is mendetory");
			}
			
			if((u.getCity() == null) || ( u.getCity().equals("")) ) {
				throw new UserException("City is mendetory");
			}
			
			if((u.getCompany() == null)  ) {
				throw new UserException("Company is mendetory");
			}
			return "User Add Successfully";
	
		
	}
	
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity< String > deleteByid(@PathVariable ("id")  int id) {
		try {
			 this.userservice.deleteByid(id);
			 return ResponseEntity.ok("Deleted !!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping ("/user/company/{company_id}")
	public  ResponseEntity<List<UserDto>> getByCompany( @PathVariable ("company_id")  Integer company_id ) {
		
		List<User> list = this.userservice.getByCompany(company_id);
		
		List<UserDto> dto = this.converter.userToDto(list);
		
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	

	
	@PutMapping(value = "/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< User>  updateProduct( @RequestBody User user , @PathVariable ("id")  Integer id  ) {
		
		 try {
		    
		        this.userservice.updateUser(user, id);
		        return ResponseEntity.ok().body(user);
		    } catch (Exception e) {
		        System.out.println("Error updating product: " + e.getMessage());
		        e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
		
	}
	

}
