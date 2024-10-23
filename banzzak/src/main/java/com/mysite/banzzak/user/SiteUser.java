package com.mysite.banzzak.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_number;

	@Column (length = 255 ,unique = true)
	private String user_id;

	@Column (length = 50 ,unique = true)
	private String nickname;

	@Column(length = 255)
	private String user_name;

	private String password;

	@Column(length = 100, unique = true)
	private String email;

}
