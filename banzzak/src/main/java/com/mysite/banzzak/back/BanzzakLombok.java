package com.mysite.banzzak.back;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter 
public class BanzzakLombok {

	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		
		BanzzakLombok banzzakLombok = new BanzzakLombok("헬로", 5);
		System.out.println(banzzakLombok.getHello());
		System.out.println(banzzakLombok.getLombok());
	}
	
}
