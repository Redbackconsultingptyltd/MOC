package au.com.redbackconsulting.moc.persistence;

import au.com.redbackconsulting.moc.persistence .manager.EntityManagerProvider;
import au.com.redbackconsulting.moc.persistence. model.HrRelations;
import au.com.redbackconsulting.moc.persistence.model.HrRelationsPk;

public class HrRelationsDAO extends BasicDAO<HrRelations, HrRelationsPk> {

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
