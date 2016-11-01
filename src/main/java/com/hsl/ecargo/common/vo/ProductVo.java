package com.hsl.ecargo.common.vo;


/**
 * product view-layer-object
 * @author hushenglang
 * @date 2015年9月7日 下午4:31:11 
 *
 */
public class ProductVo {

	/** product id */
	private int id;
	
	/** product name */
	private String name;
	
	/** product description */
	private String description;
	
	/** product brand name */
	private String brandName;
	
	/** product newest review vo */
	private ReviewVo review;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public ReviewVo getReview() {
		return review;
	}
	public void setReview(ReviewVo review) {
		this.review = review;
	}
	
}
