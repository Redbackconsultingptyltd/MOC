package au.com.redbackconsulting.moc.persistence;
 
 

import javax.persistence.EntityManager;

import au.com.redbackconsulting .moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting .moc.persistence.model.CaSystems;
import au.com.redbackconsulting .moc.persistence.model.CaSystemsPk;

public class CaSystemsDAO extends BasicDAO<CaSystems, CaSystemsPk> {
	
	public CaSystemsDAO(){
		
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	
	public 	 CaSystems  getPK (CaSystemsPk pk){
//		final EntityManager em = emProvider.get();
//			entity =em.find(entity.getClass(), entity);
//        return entity;
	 
		return null;
	}
	 
	@Override
	public String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

 
	 

}
