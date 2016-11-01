package com.hsl.ecargo.service;

import java.util.List;

import com.hsl.ecargo.common.vo.ProductVo;

/**
 * product service provides query product list and other functions
 * @author hushenglang
 * @date 2015年9月7日 下午4:34:55 
 *
 */
public interface ProductService {

	/**
	 * get brand's 10 newest products
	 * @param brandName
	 * @return List<ProductVo>
	 */
	public List<ProductVo> getProducts(String brandName);
	
	/**
	 * get 10 newest products
	 * @param brandId
	 * @return List<ProductVo>
	 */
	public List<ProductVo> getProducts();
}
