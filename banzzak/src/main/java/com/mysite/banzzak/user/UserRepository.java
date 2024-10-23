package com.mysite.banzzak.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Integer> {

	Optional<SiteUser> findByUserNumber(Integer userNumber);
	Optional<SiteUser> findByUserId(String userId);
	Optional<SiteUser> findByEmail(String email);


}
