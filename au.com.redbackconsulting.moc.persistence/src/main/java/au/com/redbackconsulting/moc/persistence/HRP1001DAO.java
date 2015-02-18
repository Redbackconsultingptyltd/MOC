package au.com.redbackconsulting.moc.persistence;

import au.com.redbackconsulting.moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1001;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1001PK;

public class HRP1001DAO extends BasicDAO<Hrp1001, Hrp1001PK>  {

	public HRP1001DAO( ) {
		super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
