package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence .model.HRP1000;
import au.com.redbackconsulting.moc.persistence.model.HRP1000PK;

public class HRP1000DAO extends BasicDAO<HRP1000, HRP1000PK>   {

	public HRP1000DAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
