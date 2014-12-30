package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model.Tenants;
import au.com.redbackconsulting.moc.persistence.model.TenantsPk;

public class TenantsDAO extends BasicDAO<Tenants,  TenantsPk> {

	public TenantsDAO( ) {
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
