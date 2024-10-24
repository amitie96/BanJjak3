package com.mysite.banzzak.notice;

import com.mysite.banzzak.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
