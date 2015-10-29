package com.baidu.statistics.config;

public class ConfigFactory {
	
	private static Config config;
	
	public Config getConfig() {
		if (config == null) {
			config = new ConfigImpl();
			config.loadConfig();
		}
		return config;
	}
}
