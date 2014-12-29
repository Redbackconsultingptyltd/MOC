package au.com.redbackconsulting.moc.persistence;

 import au.com.redbackconsulting .moc.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting .moc.persistence.model.HrObjectsConstraints;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsConstraintsPk;

public class HrObjectsConstraintsDAO extends BasicDAO<HrObjectsConstraints, HrObjectsConstraintsPk>    {

	public HrObjectsConstraintsDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
