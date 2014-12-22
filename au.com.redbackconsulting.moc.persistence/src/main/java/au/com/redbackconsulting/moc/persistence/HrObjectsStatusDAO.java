package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence .model.HrObjectsStatus;

public class HrObjectsStatusDAO extends BasicDAO<HrObjectsStatus>  {

	public HrObjectsStatusDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
