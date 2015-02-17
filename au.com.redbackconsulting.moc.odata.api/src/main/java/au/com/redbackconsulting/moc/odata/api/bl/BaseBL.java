package au.com.redbackconsulting.moc.odata.api.bl;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class BaseBL implements IBLModel {

	protected BLModelFactory bmf=null;
	
	
	public BaseBL(BLModelFactory bmf){
		this.bmf=bmf;
	} 
	
	public IBLModelFactory getBLModelFactory(){
		
		return bmf;
	}
	
	protected String convertDateToString(Date date, String format){
		 SimpleDateFormat formatter = new SimpleDateFormat(format);
		 return formatter.format(date);
		
		
	}
 
	protected Date convertStringToDate(String date, String format){
		try {
			 SimpleDateFormat formatter = new SimpleDateFormat(format);
			 return formatter.parse(date);
			
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
}
