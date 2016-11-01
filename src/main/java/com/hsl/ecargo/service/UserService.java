package com.hsl.ecargo.service;

import com.hsl.ecargo.common.vo.UserVo;

/**
 * user service provides get user and other functions
 * @author hushenglang
 * @date 2015年9月8日 下午3:44:25 
 *
 */
public interface UserService {

	/**
	 * get user by email
	 * @param email
	 * @return UserVo;
	 */
	public UserVo getUser(String email);
}
