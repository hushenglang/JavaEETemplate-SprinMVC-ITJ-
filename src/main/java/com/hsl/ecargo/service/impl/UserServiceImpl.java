package com.hsl.ecargo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsl.ecargo.common.po.UserPo;
import com.hsl.ecargo.common.util.BeanUtil;
import com.hsl.ecargo.common.vo.UserVo;
import com.hsl.ecargo.dao.UserMapper;
import com.hsl.ecargo.service.UserService;

/**
 * user service provides get user and other functions
 * @author hushenglang
 * @date 2015年9月8日 下午7:19:28 
 *
 */
@Service
public class UserServiceImpl implements UserService{
	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * get user by email
	 * @param email
	 * @return UserVo;
	 */
	@Override
	public UserVo getUser(String email) {
		log.info("-- getUser()");
		if(log.isDebugEnabled()){
			log.debug("param: userEmail="+email);
		}
		UserPo userPo = userMapper.getUserByEmail(email);
		if(userPo==null){
			log.info("-- user not existed");
			return null;
		}
		UserVo userVo = new UserVo();
		BeanUtil.copyBeanProperties(userPo, userVo);
		return userVo;
	}

}
