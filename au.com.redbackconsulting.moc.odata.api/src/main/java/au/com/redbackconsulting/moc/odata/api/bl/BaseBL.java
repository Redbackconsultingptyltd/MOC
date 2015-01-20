package au.com.redbackconsulting.moc.odata.api.bl;


public abstract class BaseBL implements IBLModel {

	private IBLModelFactory bmf=null;
	
	public BaseBL(IBLModelFactory bmf){
		this.bmf=bmf;
	} 
	
	public IBLModelFactory getBLModelFactory(){
		
		return bmf;
	}
 
	
}
