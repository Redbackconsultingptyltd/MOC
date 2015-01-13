package au.com.redbackconsulting.moc.persistence;

 
import au.com.redbackconsulting.  moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.  moc.persistence.model.HrObjectRel;
import au.com.redbackconsulting.moc.persistence.model.HrObjectRelPK;

public class HrObjectRelDAO extends BasicDAO<HrObjectRel, HrObjectRelPK>  {

	public HrObjectRelDAO() {
		super(PersistenceManager.getInstance().getEntityManagerProvider());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
