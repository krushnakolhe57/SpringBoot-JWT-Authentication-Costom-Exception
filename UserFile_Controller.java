package com.sb.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.entity.User;
import com.sb.exception.UserException;
import com.sb.service.UserService;
import com.sb.service.UserService_File;


@RestController
public class UserFile_Controller {
	
	@Autowired
	private UserService_File userService_File;
	
	@GetMapping("/public/home")
	public String openForm() {
		
		return "This is home !!!!!!!!!!!!";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "This is login form";
	}
	
//	@PreAuthorize ("hasRole('NORMAL') ")
	@GetMapping("/normal/ragister")
	public String ragisterForm() {
		
		return "This is ragister form";
	}
	
//	@PreAuthorize ("hasRole('ADMIN') ")
	@GetMapping("admin/welcome")
	public String welcomeForm() {
		
		return "This is welcome form";
	}
	
	
	@GetMapping("/current-user")
	public String getCurrentUser(Principal principle) {
		
		return principle.getName();
	}
	
	


	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipart) {
	    
			
			try {
				
				if(multipart.isEmpty()) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Not get");
				}
				
				if(userService_File.uploadFile(multipart)) {
//					return ResponseEntity.ok("Upload Success");
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipart.getOriginalFilename()).toUriString());
				}
				
			} catch (Exception e) {
	
			}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
		
	}
	
	 
	
	
	
	
//	public UserFile_Controller( UserService userservice) {
//		
//				this.userservice = userservice;
//		}
//	
//	@GetMapping ("/users")
//	public  List<User> getAllUsers() {
//		
//
//		return this.userservice.getAllUsers();
//	
//	}
//	@GetMapping ("/user/{id}")
//	public User getById(@PathVariable ("id")  int id) throws UserException  {
//		
//		User uu = null;
//		
//		uu = this.userservice.getById(id);
//		if(uu == null) {
//			throw new UserException("User Not Get");
//		}
//		return uu;
//	}
//	
//	@PostMapping ("/adduser")
//	public String addUser (@RequestBody User user) {
//	
//
//		try {
//			this.userservice.addUser(user);
//			return "User Add Successfully";
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return  "User Not Add ";
//		}
//		
//	}
//
//	
//	@DeleteMapping ("/user/{id}")
//	public void deleteByid(@PathVariable ("id")  int id)  {
//		
//		this.userservice.deleteByid(id);
//	}
//	
//	@PutMapping ("/user/{id}")
//	public User updateUser( @RequestBody User user , @PathVariable ("id")  int id  )  {
//		
//		userservice.updateUser( user , id );
//		return user;
//	}
//	
	

}
