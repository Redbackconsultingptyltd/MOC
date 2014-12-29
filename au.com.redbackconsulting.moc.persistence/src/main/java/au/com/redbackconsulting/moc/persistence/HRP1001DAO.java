package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence .model.HRP1001;
import au.com.redbackconsulting.moc.persistence.model.HRP1001PK;

public class HRP1001DAO extends BasicDAO<HRP1001, HRP1001PK> {

	public HRP1001DAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
