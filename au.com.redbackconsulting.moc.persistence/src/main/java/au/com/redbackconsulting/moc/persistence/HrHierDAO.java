package au.com.redbackconsulting.moc.persistence;
 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;

public class HrHierDAO extends BasicDAO<Hrhier, HrhierPK>  {

	
	
	public HrHierDAO() {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	public String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

 
}
