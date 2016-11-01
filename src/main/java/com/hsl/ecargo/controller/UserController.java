package com.hsl.ecargo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsl.ecargo.common.vo.UserVo;
import com.hsl.ecargo.service.UserService;

/**
 * user controller provides query user related RESTFUL api;
 * @author hushenglang
 * @date 2015年9月9日 下午3:01:46 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * get user json object by user's email
	 * @param userEmail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public UserVo getUserByEmail(@RequestParam("useremail")String userEmail){
		log.info("-- getUserByEmail()");
		if(log.isDebugEnabled()){
			log.debug("--> param: userEmail="+userEmail);
		}
		UserVo userVo = userService.getUser(userEmail);
		return userVo;
	}
}
