package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;

public class HrObjectRelDAO extends BasicDAO<Hrobjectrel, HrobjectrelPK>  {

	public HrObjectRelDAO( ) {
		 
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
