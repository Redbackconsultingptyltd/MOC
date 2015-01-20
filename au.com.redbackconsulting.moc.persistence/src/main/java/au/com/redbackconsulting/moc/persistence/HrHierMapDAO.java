package au.com.redbackconsulting.moc.persistence;
 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;

public class HrHierMapDAO extends BasicDAO<Hrhiermap, HrhiermapPK>  {

	 
	

	public HrHierMapDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
		 
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
