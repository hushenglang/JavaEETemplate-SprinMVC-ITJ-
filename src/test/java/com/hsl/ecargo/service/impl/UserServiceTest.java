package com.hsl.ecargo.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hsl.ecargo.common.vo.UserVo;
import com.hsl.ecargo.service.UserService;

@TransactionConfiguration(transactionManager = "txManager")
public class UserServiceTest extends JUnitServiceBase{
	@Autowired
	UserService userService;
	
	/**
	 * get user by email
	 * @param email
	 * @return UserVo;
	 */
	@Test
	public void getUser(){
		//case 1: email does existed!
		String email="hushenglang@gmail.com";
		UserVo userVo = userService.getUser(email);
		assertEquals(true,(userVo!=null));
		
		//case 2: email does not existed!
		email="joehu@gmail.com";
		userVo = userService.getUser(email);
		assertEquals(true,(userVo==null));
	}
}
