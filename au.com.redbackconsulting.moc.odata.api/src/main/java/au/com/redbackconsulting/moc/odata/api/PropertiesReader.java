package au.com.redbackconsulting.moc.odata.api;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PropertiesReader {
	Properties properties = new Properties();
	public PropertiesReader(HttpServletRequest request){
	
	try {

		final InputStream is = request.getServletContext()
				.getResourceAsStream("/WEB-INF/config.properties");
		try {
			properties.load(is);

		} finally {
			is.close();
		}

	} catch (Exception asd) {

	} 
	}
	
	public String getDateFormat(String keyValue) {

		try {

			Object obj = properties.get("DATE_FORMAT");
			 
			return (String) obj;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}



