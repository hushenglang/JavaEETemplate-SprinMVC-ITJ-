package com.hsl.ecargo.common.util;

import java.lang.reflect.Constructor;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.WrapDynaBean;
import org.apache.log4j.Logger;

/**
 * Java Bean Reflection Util.java
 * @author hushenglang
 * @date 2015年9月8日 下午7:25:51 
 *
 */
public class BeanUtil {
	private static final Logger logger = Logger.getLogger(BeanUtil.class);
	
	protected BeanUtil() {
	}

	/**
	 * copy source's bean properties which exsited in target's bean.
	 * @param source
	 * @param target
	 */
	public static void copyBeanProperties(Object source, Object target) {
		WrapDynaBean sourceWrapDynaBean = new WrapDynaBean(source);
		WrapDynaBean targetWrapDynaBean = new WrapDynaBean(target);
		DynaProperty[] dynaProperties = targetWrapDynaBean.getDynaClass().getDynaProperties();
		for (DynaProperty dynaProperty : dynaProperties) {
			String name = dynaProperty.getName();
			try {
				Object value = sourceWrapDynaBean.get(name);
				if (value != null) {
					targetWrapDynaBean.set(name, value);
				}
			} catch (Exception e) {
				logger.warn("bean attribute name:"+name+" no set method");
			}
		}
	}
	
	public static Object getProperty(Object obj, String propertyName) {
		try {
			return PropertyUtils.getProperty(obj, propertyName);
		} catch (Exception e) {
			logger.error("copy bean error occured!",e);
			return null;
		}
	}
	public static void setProperty(Object obj, String propertyName,
			Object propertyValue) {
		try {
			PropertyUtils.setProperty(obj, propertyName, propertyValue);
		} catch (Exception e) {
			logger.error("copy bean error occured!",e);
		}
	}
	
	public static Object createClass(String name,Object []o) throws Exception
	{
	   Class myClass =Class.forName(name);
	   Class[] argsClass = new Class[o.length];
	   for (int i = 0; i< o.length; i++) {
		   logger.debug("o[" + i + "]:" + o[i]);
	       argsClass[i] = o[i].getClass();
	   }
	   
	   try {
		   Constructor cons = myClass.getConstructor(argsClass);
		   return cons.newInstance(o);
	   } catch (Exception e) {
		   logger.error("instance error", e);
		   return myClass.newInstance();
	   }
	}
}
