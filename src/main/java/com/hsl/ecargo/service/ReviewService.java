package com.hsl.ecargo.service;

/**
 * review service provides create review and other functions
 * @author hushenglang
 * @date 2015年9月8日 下午3:44:25 
 *
 */
public interface ReviewService {

	/**
	 * create review on a product by a user. 
	 * @param email
	 * @param productId
	 * @param rating
	 * @param comment
	 * @return if email doesn't exist then false;
	 */
	public boolean createReview(String email, String productId, String rating, String comment);
}
