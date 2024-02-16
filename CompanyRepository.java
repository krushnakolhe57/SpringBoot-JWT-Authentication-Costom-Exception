package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	Company findByCompanyName(String companyName);
}
