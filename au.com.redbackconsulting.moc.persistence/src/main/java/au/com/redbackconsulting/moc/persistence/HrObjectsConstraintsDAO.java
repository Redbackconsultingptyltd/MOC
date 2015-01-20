package au.com.redbackconsulting.moc.persistence;

 import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;

public class HrObjectsConstraintsDAO extends BasicDAO<Hrobjectsconstraint, HrobjectsconstraintPK>    {

	public HrObjectsConstraintsDAO( ) {
		 
			 super(PersistenceManager.getInstance().getEntityManagerProvider());
		}
	 

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
