package au.com.redbackconsulting.moc.persistence.model;

import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_CASYSTEM;
public class PKFactory  {

	
	private PKFactory(){}
	public static PKFactory getInstance(){
		return new PKFactory();
	}
	
	public IPkModel getPKInstance (int key){
		switch (key) {
		case PK_KEY_CASYSTEM:
			return new CaSystemsPk();
		

		default:
			break;
		}
		return null;
	}
}
