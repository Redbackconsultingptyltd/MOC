package au.com.redbackconsulting.moc.persistence;
 
 

import au.com.redbackconsulting .moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting .moc.persistence.model.CaSystems;
import au.com.redbackconsulting .moc.persistence.model.CaSystemsPk;

public class CaSystemsDAO extends BasicDAO<CaSystems> {
	
	public CaSystemsDAO(){
		
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	
	public 	 CaSystems  getPK (CaSystemsPk pk){
		return null;
		
	}
	 
	@Override
	public String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

 
	 

}
