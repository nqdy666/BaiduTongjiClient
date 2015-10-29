package com.baidu.statistics.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;


public class FileUtil {
	

	public static File getFileFromResource(String resource) {
		URL resourceUrl = FileUtil.class.getResource(resource);
		if (resourceUrl == null) {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			resourceUrl = classLoader.getResource(resource);
		}
		URI resourceUri;
		try {
			resourceUri = new URI(resourceUrl.toString());
		} catch (URISyntaxException e) {
			return null;
		}
		return new File(resourceUri.getPath());
	}

	public static Properties loadProperties(String resource) {
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = FileUtil.class.getResourceAsStream(resource);
			if (is == null) {
				ClassLoader classLoader = Thread.currentThread()
						.getContextClassLoader();
				is = classLoader.getResourceAsStream(resource);
			}
			if (is != null) {
				properties.load(is);
			}
		} catch (IOException e) {
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
}
