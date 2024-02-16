package com.sb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.User;
import com.sb.entity.UserDto;
import com.sb.repository.CompanyRepository;

@Service
public class UserConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public UserDto userToDto(User user) {
		
		UserDto dto = this.modelMapper.map(user, UserDto.class);
		
//		UserDto dto = new UserDto();
//		
//		dto.setUserName(user.getName());
//		dto.setUserCompany(user.getCompany().getCompanyName());
//		
		return dto;
		
	}
	
	public List<UserDto> userToDto(List<User> user){
		
		return user.stream().map(x -> userToDto(x)).collect(Collectors.toList());
	}
	
	
	public User dtoToUser(UserDto dto) {
		
		User user = this.modelMapper.map(dto, User.class);
		
//		User user  =   new User();
//		
//		user.setName(dto.getUserName());
//		user.setCompany(companyRepository.findByCompanyName(dto.getUserCompany()));
		
		return user;
	}
	

	public List<User> dtoToUser(List<UserDto> dto){
		
		return dto.stream().map(x -> dtoToUser(x)).collect(Collectors.toList());
	}
	

}
