package com.hsl.ecargo.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hsl.ecargo.common.vo.ProductVo;
import com.hsl.ecargo.service.ProductService;

@TransactionConfiguration(transactionManager = "txManager")
public class ProductServiceTest extends JUnitServiceBase {
	@Autowired
	ProductService productService;
	
	/**
	 * get brand id's 10 newest products
	 * @param brandId
	 * @return List<ProductVo>
	 */
	@Test
	public void getProductsWithBrandId(){
		//case 1: brandId existed;
		String brandId="1";
		List<ProductVo> productList = productService.getProducts(brandId);
		int size = productList.size();
		assertEquals(true,(size>0));
		
		//case 2: brandId>0 does not existed;
		brandId="99999";
		productList = productService.getProducts(brandId);
		size = productList.size();
		assertEquals(true,(size==0));
		
		//case 3: brandId<0 does not existed;
		brandId="-1";
		productList = productService.getProducts(brandId);
		size = productList.size();
		assertEquals(true,(size>0));
	}
	
	/**
	 * get 10 newest products
	 * @param brandId
	 * @return List<ProductVo>
	 */
	@Test
	public void getProducts(){
		//case 1: query lasted 10 product;
		List<ProductVo> productList = productService.getProducts();
		int size = productList.size();
		assertEquals(true,(size<=10));
	}
}
