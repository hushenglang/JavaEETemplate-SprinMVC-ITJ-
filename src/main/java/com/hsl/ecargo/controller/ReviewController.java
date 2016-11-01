package com.hsl.ecargo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsl.ecargo.common.vo.AjaxResult;
import com.hsl.ecargo.service.ReviewService;

/**
 * review controller provides creating review and other review related RESTFUL api;
 * @author hushenglang
 * @date 2015年9月8日 上午9:01:25 
 *
 */
@Controller
@RequestMapping("/review")
public class ReviewController {
	private static final Logger log = Logger.getLogger(ReviewController.class);
	
	@Autowired
	ReviewService reviewService;
	
	/**
	 * create review handler
	 * @param userEmail user's email
	 * @param productId product id
	 * @param rating rating [0-10]
	 * @param comment comment
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public AjaxResult createReviewHandler(@RequestParam("useremail")String userEmail, @RequestParam("productid")String productId, 
			@RequestParam("rating")String rating, @RequestParam(value="comment", required=false)String comment){
		log.info("-- createReviewHandler()");
		if(log.isDebugEnabled()){
			log.debug("--> param: userEmail="+userEmail+"; productId="+productId+"; rating="+rating+"; comment="+comment);
		}
		AjaxResult art = new AjaxResult();
		boolean flag = reviewService.createReview(userEmail, productId, rating, comment);
		if(flag){
			log.info("-- create view success!");
			art.setCode(AjaxResult.SUCCESS);
		}else{
			log.info("-- create view failed!");
			art.setCode(AjaxResult.FAIL);
			art.setErrorMsg("email is not existed!");
		}
		return art;
	}
}
