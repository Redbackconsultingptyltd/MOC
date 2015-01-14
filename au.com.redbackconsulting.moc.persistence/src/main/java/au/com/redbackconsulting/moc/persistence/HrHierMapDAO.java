package au.com.redbackconsulting.moc.persistence;
 
import au.com.redbackconsulting. moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting .moc.persistence.model.HrHierMap;
import au.com.redbackconsulting.moc.persistence.model.HrHierMapPk;

public class HrHierMapDAO extends BasicDAO<HrHierMap, HrHierMapPk>  {

	 
	

	public HrHierMapDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
		 
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
