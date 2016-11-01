package com.hsl.ecargo.common.po;

/**
 * product view pojo
 * @author hushenglang
 * @date 2015年9月9日 下午2:44:01 
 *
 */
public class VProductPo {

	/**product id db column name*/
	public static final String PRODUCT_ID = "product_id";
	
	/**product name db column name*/
	public static final String PRODUCT_NAME = "product_name";
	
	/**product desc db column name*/
	public static final String PRODUCT_DESC = "product_desc";
	
	/**brand name db column name*/
	public static final String BRAND_NAME = "brand_name";
	
	/**comment db column name*/
	public static final String COMMENT = "comment";
	
	/**rating db column name*/
	public static final String RATING = "rating";

	/**user name db column name*/
	public static final String USER_NAME = "user_name";
	
	/**review create date db column name*/
	public static final String REVIEW_CREATE_DATE = "review_create_date";
	
	
	
	/**product id*/
	private String productId;
	
	/**product name */
	private String productName;
	
	/**product desc */
	private String productDesc;
	
	/**brand name */
	private String brandName;
	
	/**comment */
	private String comment;
	
	/**rating */
	private String rating;

	/**user name */
	private String userName;
	
	/**review create date */
	private String reviewCreateDate;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReviewCreateDate() {
		return reviewCreateDate;
	}

	public void setReviewCreateDate(String reviewCreateDate) {
		this.reviewCreateDate = reviewCreateDate;
	}
	
}
