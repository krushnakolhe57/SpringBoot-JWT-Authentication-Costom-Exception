package com.sb.config;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sb.exception.UserException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHelper {
	
	public static final long  TOKEN_VALIDITY = 5*60*60;
	
	private static final String secret ="afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";
	  
	
	
	public String getUsernameFromToken(String token) throws UserException {
		 
		return getClaimsFromToken(token,   Claims::getSubject);
	}
	
	
	
	public <T> T getClaimsFromToken(String token , Function<Claims , T >  claimsResolver) throws UserException {
		
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	


	 public static Claims getAllClaimsFromToken(String token) throws UserException {
		 
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	    }
	 
	 
	 private Boolean isTokenExpired(String token) throws UserException  {
		 
		 final Date expiration  =  getExpirationDateFromToken(token);
		 
		return expiration.before(new Date());
	 }
	 
	 
	 
	 public Date getExpirationDateFromToken (String token ) throws UserException   {
		 
		 return getClaimsFromToken(token,   Claims :: getExpiration);
		 
	 }
	 
	 
	 
	 public String generateToken(UserDetails userDetails) {
		 
		 Map<String, Object>  claims = new HashMap<String, Object>();
		 
		 return doGenerateToken(claims, userDetails.getUsername()); 
	 }
	 
	 
	 private String doGenerateToken(Map<String, Object> claims , String subject) {
		 
		 Date expiration = new Date(  System.currentTimeMillis()+ TOKEN_VALIDITY*1000   );
		 
		 return Jwts.builder().setClaims(claims)
				 								.setSubject(subject)
				 								.setIssuedAt(new Date(System.currentTimeMillis()))
				 								.setExpiration(expiration)
				 								.signWith(SignatureAlgorithm.HS512, secret).compact();
	 }
	 
	 
	 
	 public Boolean validateToken (String token , UserDetails userDetails) throws UserException  {
		 
		 Boolean f = false;
		 
		 final String username = getUsernameFromToken(token);
		 
		 if(username.equals(userDetails.getUsername())  &&  ! isTokenExpired(token)) {
			 
			 f = true;
		 }
		 
		 return f; 
	 }
	 
	 
	 
	 
}
