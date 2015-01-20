package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;

public class HRP1000DAO extends BasicDAO<Hrp1000, Hrp1000PK>   {

	public HRP1000DAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
