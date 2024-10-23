package com.mysite.banzzak;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.banzzak.question.QuestionService;

@SpringBootTest
class BanzzakApplicationTests {

	@Autowired
	private QuestionService questionService;


	/*
	 * @Test void testJpa() { for (int i =1; i<=300; i++) { String subject =
	 * String.format("테스트 데이터입니다:[%03d]", i); String content = "내용 없음 ";
	 * this.questionService.create(subject, content); } }
	 */
}