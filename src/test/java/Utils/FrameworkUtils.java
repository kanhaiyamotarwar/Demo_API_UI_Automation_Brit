package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FrameworkUtils {

	public static Properties properties;

	public static String readpropertiesfile(String Key) throws IOException {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/Global.properties");
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Can not find key: " + Key + "in config file due to exception" + e);
		}
		return properties.getProperty(Key);
	}

}
