package com.hsl.ecargo.common.vo;

import java.util.Date;

/**
 * user view-layer-object
 * @author hushenglang
 * @date 2015年9月8日 下午7:17:28 
 *
 */
public class UserVo {
	/** user id */
	private int id;
	
	/** user name */
	private String name;
	
	/** user email */
	private String email;
	
	/** user birthDay */
	private Date birthDay;
	
	/** user type[c-client|m-merchant] */
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
