package com.hsl.ecargo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hsl.ecargo.common.vo.ProductVo;
import com.hsl.ecargo.service.ProductService;

/**
 * product controller provides query product list and other product related RESTFUL api;
 * @author hushenglang
 * @date 2015年9月7日 下午4:10:36 
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Logger log = Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	/**
	 * provide restful api to get product list json string.
	 * @param brandId 
	 * @return product list json string
	 */
	@ResponseBody
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public List<ProductVo> queryProductHandler(){
		log.info("-- queryProductHandler()");
		List<ProductVo> productlist = productService.getProducts();
		return productlist;
	}
	
	/**
	 * provide restful api to get product list json string by brand id.
	 * @param brandId 
	 * @return product list json string
	 */
	@ResponseBody
	@RequestMapping(value="/query/{brandName}", method=RequestMethod.GET)
	public List<ProductVo> queryProductByNameHandler(@PathVariable("brandName") String brandName){
		log.info("-- queryProductByBrandIdHandler()");
		if(log.isDebugEnabled()){
			log.debug("--> param: brandName"+brandName);
		}
		List<ProductVo> productlist = productService.getProducts(brandName);
		return productlist;
	}
	
}
