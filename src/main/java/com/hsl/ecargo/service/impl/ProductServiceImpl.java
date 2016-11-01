package com.hsl.ecargo.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.hsl.ecargo.common.po.VProductPo;
import com.hsl.ecargo.common.util.DBUtil;
import com.hsl.ecargo.common.vo.ProductVo;
import com.hsl.ecargo.common.vo.ReviewVo;
import com.hsl.ecargo.service.ProductService;

/**
 * product service provides query product list and other functions
 * @author hushenglang
 * @date 2015年9月7日 下午4:34:55 
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger log = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	DataSourceTransactionManager txn;
	
	/**
	 * get brand's 10 newest products
	 * @param brandId
	 * @return List<ProductVo>
	 */
	@Override
	public List<ProductVo> getProducts(String brandName){
		log.info("-- getProducts(brandName)");
		if(log.isDebugEnabled()){
			log.debug("--> param: brandName="+brandName);
		}
		final int rowNum = 10;
		return queryProducts(brandName,rowNum);
	}
	
	/**
	 * get 10 newest products
	 * @param brandId
	 * @return List<ProductVo>
	 */
	@Override
	public List<ProductVo> getProducts(){
		log.info("-- getProducts()");
		final int rowNum = 10;
		return queryProducts("",rowNum);
	}
	
	/**
	 * get brand id's rowNum newest products
	 * @param brandId -1-query not by brandid; other- query by brandid
	 * @param rowNum
	 * @return
	 */
	private List<ProductVo> queryProducts(String brandName, int rowNum){
		if(log.isDebugEnabled()){
			log.debug("--> queryProducts() param: brandName="+brandName+" rowNum="+rowNum);
		}
		List<ProductVo> productList = new ArrayList<ProductVo>();
		Connection conn = null;
		CallableStatement cst = null;
		ResultSet rst = null;
		try {
			conn = txn.getDataSource().getConnection();
			cst = conn.prepareCall("{call sq_query_product(?,?)}");
			cst.setString(1, ((brandName.length()==0)?"":"%"+brandName+"%"));//query product by brand name
			cst.setInt(2, rowNum);//10 rows would query
			cst.execute();
			rst = cst.getResultSet();
			while(rst.next()){
				int prdId = rst.getInt(VProductPo.PRODUCT_ID);
				String prdName = rst.getString(VProductPo.PRODUCT_NAME);
				String prdDesc = rst.getString(VProductPo.PRODUCT_DESC);
				String cbrandName = rst.getString(VProductPo.BRAND_NAME);
				String comment = rst.getString(VProductPo.COMMENT);
				String rating = rst.getString(VProductPo.RATING);
				String userName = rst.getString(VProductPo.USER_NAME);
				Date reviewDate = rst.getDate(VProductPo.REVIEW_CREATE_DATE);
				ProductVo productVo = new ProductVo();
				productVo.setId(prdId);
				productVo.setName(prdName);
				productVo.setDescription(prdDesc);
				productVo.setBrandName(cbrandName);
				ReviewVo reviewVo= new ReviewVo();
				reviewVo.setSummary(comment);
				reviewVo.setRating(rating);
				reviewVo.setUserName(userName);
				reviewVo.setReview_create_date(reviewDate);
				productVo.setReview(reviewVo);
				productList.add(productVo);
			}
		} catch (SQLException e) {
			log.error("-- queryProducts() error occured!",e);
		} finally{
			DBUtil.closeResources(rst, cst, conn);
		}
		if(log.isDebugEnabled()){
			log.debug("--query productList size is "+productList);
		}
		return productList;
	}
}
