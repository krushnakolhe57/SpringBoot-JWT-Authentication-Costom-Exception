package com.sb.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@Entity
@Table(name = "user")
@Data
public class User {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	private Integer id;
	private String name;
	private String mail;
	private String city;
	private String password;
	
	@Transient
	private List<Rating> rating = new ArrayList<Rating>();
	
	@ManyToOne
	 @JoinColumn(name = "company_company_id")
	private Company company;
	
	@ManyToMany (fetch = FetchType.EAGER  , cascade = CascadeType.ALL)
	@JoinTable ( name = "user_roles" ,
							joinColumns = @JoinColumn( name = "users_Id" , referencedColumnName = "id") ,
							inverseJoinColumns = @JoinColumn(referencedColumnName = "id" , name = "role_id" )  )
	private Set<Role>  roles;
	
	
	@Lob
	private byte[] image;
	
	@Bean
	User user(){
		return new User();
	}

	
	
}
