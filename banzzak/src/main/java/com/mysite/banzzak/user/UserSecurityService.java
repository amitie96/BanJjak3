package com.mysite.banzzak.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mysite.banzzak.user.SiteUser;
import com.mysite.banzzak.user.UserRepository;
import com.mysite.banzzak.user.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{

		String username = String.valueOf(userId);
		Optional<SiteUser> _siteUser = this.userRepository.findByUserId(userId);

		if (_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}

		SiteUser siteUser = _siteUser.get();
		List<GrantedAuthority> authorities = new ArrayList<>();

		if ("admin".equals(userId)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}

		return new User(siteUser.getUserId(), siteUser.getPassword(), authorities);
	}
}
