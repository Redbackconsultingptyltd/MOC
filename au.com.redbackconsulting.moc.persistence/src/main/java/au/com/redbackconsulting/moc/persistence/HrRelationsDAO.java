package au.com.redbackconsulting.moc.persistence;

import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence. model.HrRelations;

public class HrRelationsDAO extends BasicDAO<HrRelations> {

	public HrRelationsDAO(EntityManagerProvider emProvider) {
		super(emProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
