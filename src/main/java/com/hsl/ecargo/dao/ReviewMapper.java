package com.hsl.ecargo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.hsl.ecargo.common.po.ReviewPo;

/**
 * review dao
 * @author hushenglang
 * @date 2015年9月8日 下午4:04:43 
 *
 */
@Repository
public interface ReviewMapper {

	/**
	 * insert review and set is_new=1;
	 * @param reviewPo
	 */
	@Insert("INSERT INTO t_review(rating, comment, product_id, user_id, create_date, is_new) VALUES( #{rating}, #{comment}, #{productId}, #{userId}, #{dateTime}, 1)")
	@Options(flushCache = true)
	public void insertReview(ReviewPo reviewPo);
	
	/**
	 * update product's review is_new=0
	 * @param productId
	 */
	@Update("UPDATE t_review SET is_new=0 WHERE product_id=#{productId}")
	@Options(flushCache = true)
	public void updateReviewIsNewFlag(@Param("productId") int productId);
	
}
