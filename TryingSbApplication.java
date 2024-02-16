package com.sb;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TryingSbApplication  {
	
	
	 @Bean
	    ModelMapper modelMapper() {
			return new ModelMapper();	
		}
	 
	 @Bean
	     Logger logger() {
	        return LoggerFactory.getLogger(TryingSbApplication.class);
	    }


	public static void main(String[] args) {
		
		
//	ApplicationContext context =
				SpringApplication.run(TryingSbApplication.class, args);
				
				
				

		
		
		
		
//
//		UserRepository ur = context.getBean(UserRepository.class);
//
//		// Save
//
		
//				User user = new User("KK", "Mumbai", new Company(11, "TCS", 1200.0));
//				User user2 = new User("Rahul", "Pune",new Company(13, "TCS2", 1500.0));
//		
//				List<User> ll = List.of(user, user2);
//
//					ur.saveAll(ll);
//					
//					List<User> ll1 =(List<User>) ur.findById(1);
//					
//					for(User uu : ll1) {
//						
//						System.out.println(uu.getId() + " "+uu.getName()+" "+uu.getCity()+" "+uu.getCompany().getCompany_Id()+" "+uu.getCompany().getCompanyName());
//						
//					}
					
					
//
//		// Update
//
//		
//				  Optional<User> op = ur.findById(1);
//				  
//				  User uu = op.get();
//				  
//				  uu.setCity("Nagpur");
//				  
//				  User user3 = ur.save(uu);
//				  
//				  System.out.println(user3);
//				 
//
//		// GetAll
//
//		  		ur.findAll().forEach(user1 ->  System.out.println(user1));
//
//		// delete
//
//			ur.deleteById(2);
//			System.out.println(" After delete : ");
//			
//			ur.findAll().forEach(user1 ->  System.out.println(user1));
//	
//	// MyMethode
//
//			ur.findByNameContaining("shna").forEach(user1-> System.out.println(user1));
//			
//			System.out.println(" >>>>>>>>>>>>>>>>>>>>");
//			
//			ur.findByNameOrCity("Krushna" , "Pune").forEach(user1 -> System.out.println(user1));
//		
//			ur.getAllUser().forEach(u -> System.out.println(u));
//			
//			System.out.println(" >>>>>>>>>>>>>>>>>>>>");
//			
//			ur.getByName("Krushna").forEach(user1 -> System.out.println(user1));
//		
//				System.out.println(" >>>>>>>>>>>>>>>>>>>>");
//		
//				ur.getUsers().forEach(user1 -> System.out.println(user1));

	}

}
