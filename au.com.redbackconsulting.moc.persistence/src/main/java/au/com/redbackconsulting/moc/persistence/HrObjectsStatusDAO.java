package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsstatus;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;

public class HrObjectsStatusDAO extends BasicDAO<Hrobjectsstatus, HrobjectsstatusPK>  {

	public HrObjectsStatusDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
