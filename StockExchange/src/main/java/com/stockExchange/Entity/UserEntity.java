package com.stockExchange.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.stockExchange.dto.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column
	private String username;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String pan;
	
	@Column
	private Long number;
	
	@Column
	private String role;
	
	@Column
	private String password;
	
	@Column
	private LocalDateTime createdAt;
	
	public UserEntity(UserModel user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.number = user.getNumber();
		this.role = user.getRole();
		this.pan = user.getPan();
		this.createdAt = LocalDateTime.now();
	}
}
