package au.com.redbackconsulting.moc.persistence;
 
import au.com.redbackconsulting .moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.moc .persistence.model.HrHier;
import au.com.redbackconsulting.moc.persistence.model.HrHierPk;

public class HrHierDAO extends BasicDAO<HrHier, HrHierPk>  {

	public HrHierDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

 
}
