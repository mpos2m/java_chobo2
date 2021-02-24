package java_chobo2.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesEx {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("url", "jdbc:mysql://localhost:3306/mysql_study?useSSL=false");
		prop.setProperty("user", "user_mysql_study");
		prop.setProperty("password", "rootroot");
		
		//file저장
		try {
			prop.store(new FileOutputStream("oupt.txt"), "Properties Example");
			prop.store(new FileOutputStream("oupt2.properties"), "Properties Example");
			prop.storeToXML(new FileOutputStream("oupt.xml"), "Properties Example", "UTF-8");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// file 로드
		
		Properties loadProp = new Properties();
		Properties xmlProp = new Properties();
		try {
			loadProp.load(new FileInputStream("oupt.txt"));
			prnProperties(loadProp);
			System.out.println("====================");
			xmlProp.load(new FileInputStream("oupt.xml"));
			prnProperties(xmlProp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void prnProperties(Properties loadProp) {
		Set<Object> keys= loadProp.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " + loadProp.getProperty((String)key));
		}
	}
}
