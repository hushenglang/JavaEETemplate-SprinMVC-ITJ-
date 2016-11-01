package com.hsl.ecargo.common.po;

import java.util.Date;

/**
 * review table PO 
 * @author hushenglang
 * @date 2015年9月8日 下午3:50:55 
 *
 */
public class ReviewPo {
	
	/** review id[autoIncrement] */
	private int id;
	
	/** rating */
	private int rating;
	
	/** comment */
	private String comment;
	
	/** product id */
	private int productId;
	
	/** user id */
	private int userId;
	
	/** date_time */
	private Date dateTime;
	
	/** is_new */
	private int isNew;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getIsNew() {
		return isNew;
	}
	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}
	
}
