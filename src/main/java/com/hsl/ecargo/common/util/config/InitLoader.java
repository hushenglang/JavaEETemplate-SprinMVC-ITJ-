package com.hsl.ecargo.common.util.config;

import java.util.Properties;

/**
 * properties holder
 * @author hushenglang
 * @date 2015年9月7日 下午4:00:09 
 *
 */
public class InitLoader {

	private String path;

	public Properties getProperties() {
		Properties properties = ConfigLoader.getInstance().getProperties(path);
		return properties;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
