package com.rickyluu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private Properties prop = new Properties();
	private InputStream input = null;
	
	public Config () {
		try {
			input =  new FileInputStream("maze.properties");
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public String getFile() {
		return prop.getProperty("file");
	}
	
	

	
	
	
	
	
}
