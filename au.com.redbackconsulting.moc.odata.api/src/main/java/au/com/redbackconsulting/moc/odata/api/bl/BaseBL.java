package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;

public abstract class BaseBL implements IBLModel {

	private IBLModelFactory bmf=null;
	
	public BaseBL(IBLModelFactory bmf){
		this.bmf=bmf;
	} 
	
	public IBLModelFactory getBLModelFactory(){
		
		return bmf;
	}
 
	
}
