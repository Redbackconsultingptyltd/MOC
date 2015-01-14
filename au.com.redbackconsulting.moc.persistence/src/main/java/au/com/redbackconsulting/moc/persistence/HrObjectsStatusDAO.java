package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence .model.HrObjectsStatus;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsStatusPk;

public class HrObjectsStatusDAO extends BasicDAO<HrObjectsStatus, HrObjectsStatusPk>  {

	public HrObjectsStatusDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
