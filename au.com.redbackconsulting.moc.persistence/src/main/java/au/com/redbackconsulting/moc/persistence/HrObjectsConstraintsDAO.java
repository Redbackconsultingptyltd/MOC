package au.com.redbackconsulting.moc.persistence;

 import au.com.redbackconsulting .moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting .moc.persistence.model.HrObjectsConstraints;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsConstraintsPk;

public class HrObjectsConstraintsDAO extends BasicDAO<HrObjectsConstraints, HrObjectsConstraintsPk>    {

	public HrObjectsConstraintsDAO( ) {
		 
			 super(PersistenceManager.getInstance().getEntityManagerProvider());
		}
	 

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
