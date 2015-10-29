package com.baidu.statistics.config;

import java.util.Properties;

import com.baidu.statistics.utils.FileUtil;

public class ConfigImpl implements Config {
	
	private Properties prop;
	
	private static final String CONFIG_NAME = "baidutongji.properties";
	
	
	public void loadConfig() {
		prop = FileUtil.loadProperties("/" + CONFIG_NAME);
	}
	
	public String getString(String key) {
		return prop.getProperty(key, "");
	}

	public Integer getInteger(String key) {
		return Integer.valueOf(getString(key));
	}
	
}
