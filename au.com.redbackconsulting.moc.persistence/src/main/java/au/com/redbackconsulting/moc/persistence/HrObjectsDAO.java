package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting .moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting. moc.persistence.model.HrObjects;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsPk;

public class HrObjectsDAO extends BasicDAO<HrObjects, HrObjectsPk>   {

	public HrObjectsDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
