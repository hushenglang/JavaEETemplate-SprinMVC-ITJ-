package com.hsl.ecargo.service.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit base class
 * @author hushenglang
 * @date 2015年9月9日 下午7:42:05 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class JUnitServiceBase extends AbstractTransactionalJUnit4SpringContextTests {

}
