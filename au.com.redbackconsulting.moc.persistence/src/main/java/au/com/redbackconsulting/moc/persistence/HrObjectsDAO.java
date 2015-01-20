package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;

public class HrObjectsDAO extends BasicDAO<Hrobject, HrobjectPK>   {

	 
		public HrObjectsDAO( ) {
			 
			 super(PersistenceManager.getInstance().getEntityManagerProvider());
		}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
