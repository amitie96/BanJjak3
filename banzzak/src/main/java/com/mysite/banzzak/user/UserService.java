package com.mysite.banzzak.user;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.banzzak.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public SiteUser create(String userId, String userName, String email, String password, String nickname) {
		SiteUser user = new SiteUser();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setPassword(passwordEncoder.encode(password));
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}
	
	public SiteUser getUser(Integer userNumber) {
		Optional<SiteUser> siteUser = this.userRepository.findByUserNumber(userNumber);
		if(siteUser.isPresent()) {
			return siteUser.get();
		} else {
			throw new DataNotFoundException("siteuser not found");
		}
		
	}

}
