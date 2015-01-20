package au.com.redbackconsulting.moc.persistence;
 
 

import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class CaSystemsDAO extends BasicDAO<Casystem, CasystemPK> {
	
	public CaSystemsDAO(){
		
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	
	public 	 Casystem   getPK (CasystemPK pk){
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
