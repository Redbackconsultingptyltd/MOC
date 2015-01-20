package au.com.redbackconsulting.moc.persistence;

import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrrelation;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;

public class HrRelationsDAO extends BasicDAO<Hrrelation, HrrelationPK> {

	public HrRelationsDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
