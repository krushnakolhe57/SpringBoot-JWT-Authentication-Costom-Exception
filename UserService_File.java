package com.sb.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sb.repository.CompanyRepository;
import com.sb.repository.UserRepository;


@Service
public class UserService_File {
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	

//	public final String uploadDirectory = "D:\\Eclipse_SpringBoot\\TryingSB\\src\\main\\resources\\static\\image";
	public final String uploadDirectory = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	UserService_File() throws IOException{
			
		}
		

		public boolean uploadFile( MultipartFile file) {
				
				boolean flag = false;
				
				try {
					 Path targetPath = Paths.get(uploadDirectory+File.separator+ file.getOriginalFilename());
					
					Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
					flag = true;
					
				} catch (Exception e) {
					System.out.println(e.getMessage());	
				}
				return flag;
			}
	

}
