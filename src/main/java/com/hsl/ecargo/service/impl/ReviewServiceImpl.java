package com.hsl.ecargo.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsl.ecargo.common.po.ReviewPo;
import com.hsl.ecargo.common.po.UserPo;
import com.hsl.ecargo.dao.ReviewMapper;
import com.hsl.ecargo.dao.UserMapper;
import com.hsl.ecargo.service.ReviewService;
/**
 * review service provides create review and other functions
 * @author hushenglang
 * @date 2015年9月7日 下午4:34:55 
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService{
	private static final Logger log = Logger.getLogger(ReviewServiceImpl.class);
	
	@Autowired
	ReviewMapper reviewMapper;
	@Autowired
	UserMapper userMapper;
	
	/**
	 * create review on a product by a user. 
	 * @param email
	 * @param productId
	 * @param rating
	 * @param comment
	 * @return if email doesn't exist then false;
	 */
	@Transactional
	@Override
	public boolean createReview(String email, String productId, String rating, String comment) {
		log.info("-- createReview()");
		if(log.isDebugEnabled()){
			log.debug("--> param: email="+email+"; productId="+productId+"; rating="+rating+"; comment="+comment);
		}
		//1.check email is existed, if so return userid by email
		if(log.isDebugEnabled()){
			log.debug("check email is existed of user_type='c'");
		}
		UserPo userPo = userMapper.getUserByEmail(email);
		if(userPo==null||!"c".equals(userPo.getType())){
			log.warn("user email doesn't existed!");
			return false;
		}
		int userId = userPo.getId();
		
		//2.update product's review is new flag
		if(log.isDebugEnabled()){
			log.debug("update product's review new flag. set old one = 0");
		}
		reviewMapper.updateReviewIsNewFlag(Integer.valueOf(productId));
		
		//3.insert review
		if(log.isDebugEnabled()){
			log.debug("-- insert review to db");
		}
		ReviewPo reviewPo = new ReviewPo();
		reviewPo.setProductId(Integer.valueOf(productId));
		reviewPo.setUserId(userId);
		reviewPo.setRating(Integer.valueOf(rating));
		reviewPo.setComment(comment);
		reviewPo.setDateTime(new Date());
		reviewMapper.insertReview(reviewPo);
		
		return true;
	}

}
