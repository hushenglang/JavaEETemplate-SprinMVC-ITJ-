package com.hsl.ecargo.common.vo;

import java.util.Date;

/**
 * review view-layer-object
 * @author hushenglang
 * @date 2015年9月7日 下午4:27:37 
 *
 */
public class ReviewVo {

	/** review summary */
	private String summary;
	
	/** review rating */
	private String rating;
	
	/** review written by user's username */
	private String userName;
	
	/** review create_date */
	private Date review_create_date;
	
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getReview_create_date() {
		return review_create_date;
	}
	public void setReview_create_date(Date review_create_date) {
		this.review_create_date = review_create_date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
