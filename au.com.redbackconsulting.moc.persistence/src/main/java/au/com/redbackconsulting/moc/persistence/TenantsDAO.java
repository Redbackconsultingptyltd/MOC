package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class TenantsDAO extends BasicDAO<Tenant,  TenantPK> {

	public TenantsDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
