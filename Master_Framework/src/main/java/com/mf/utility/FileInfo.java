package com.mf.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileInfo {
	
	public String FileData(String keyvalue) throws IOException {
		FileInputStream fs=new FileInputStream("./src/test/resources/Configuration/config.properties");
		Properties prop=new Properties();
		prop.load(fs);
		String value=prop.getProperty(keyvalue);
		return value;
	}
	

}
