package au.com.redbackconsulting.moc.odata.api.bl;


public abstract class BaseBL implements IBLModel {

	protected BLModelFactory bmf=null;
	
	public BaseBL(BLModelFactory bmf){
		this.bmf=bmf;
	} 
	
	public IBLModelFactory getBLModelFactory(){
		
		return bmf;
	}
 
	
}
