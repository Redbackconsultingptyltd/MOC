package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence .model.Tenants;
import au.com.redbackconsulting.moc.persistence.model.TenantsPk;

public class TenantsDAO extends BasicDAO<Tenants,  TenantsPk> {

	public TenantsDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
