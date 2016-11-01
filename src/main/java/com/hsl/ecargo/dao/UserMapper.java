package com.hsl.ecargo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hsl.ecargo.common.po.UserPo;

/**
 * user dao
 * @author hushenglang
 * @date 2015年9月8日 下午4:04:43 
 *
 */
@Repository
public interface UserMapper {

	/**
	 * query count of user by email and type='c'
	 * @param email
	 * @return
	 */
	@Select("SELECT count(email) FROM t_user WHERE email=#{userEmail} AND type='c'")
	public int countUserByEmail(@Param("userEmail")String email);
	
	/**
	 * get user po by email
	 * @param email
	 * @return
	 */
	@Select("SELECT id, name, email, type, birth_date FROM t_user WHERE email=#{userEmail}")
	public UserPo getUserByEmail(@Param("userEmail")String email);
	
}
