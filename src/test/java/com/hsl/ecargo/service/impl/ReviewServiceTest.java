package com.hsl.ecargo.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hsl.ecargo.service.ReviewService;

@TransactionConfiguration(transactionManager = "txManager")
public class ReviewServiceTest extends JUnitServiceBase {
	@Autowired
	ReviewService reviewService;
	
	/**
	 * create review on a product by a user. 
	 * @param email
	 * @param productId
	 * @param rating
	 * @param comment
	 * @return if email doesn't exist then false;
	 */
	@Test
	public void createReview(){
		//case 1: email existed;
		String email="hushenglang@gmail.com";
		String productId = "1";
		String rating ="10";
		String comment = "this is very great product!";
		boolean flag = reviewService.createReview(email, productId, rating, comment);
		assertEquals(true,flag);
		
		//case 2: email does not existed;
		email="joehu@gmail.com";
		flag = reviewService.createReview(email, productId, rating, comment);
		assertEquals(false,flag);
	}
}
