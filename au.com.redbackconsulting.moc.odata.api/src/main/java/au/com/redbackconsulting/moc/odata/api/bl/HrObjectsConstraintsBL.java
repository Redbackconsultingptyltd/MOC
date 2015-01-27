package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsConstraintsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class HrObjectsConstraintsBL extends BaseBL{

	public HrObjectsConstraintsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {


		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
		List<Hrobjectsconstraint> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrobjectsconstraint hrobjectscon = (Hrobjectsconstraint) iterator.next();
			Map<String, Object> map = convertData(hrobjectscon);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
		
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {


		HrobjectsconstraintPK pk = (HrobjectsconstraintPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
			Hrobjectsconstraint entity =	dao.getByPK(pk);
		result= convertData(entity);
		return result;
		} catch (Exception e) {
			int i =0;
			i=i+1;
		}
		

		return null;
	}

	@Override
	public boolean deleteData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> updateData(Map<String, Object> valueMap,
			Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> createData(Map<String, Object> valueMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Map<String, Object> convertData( Hrobjectsconstraint dataModel){

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsConstraintsEDM.objectType, dataModel.getId());
			map.put(HrObjectsConstraintsEDM.tableId, dataModel.getTableId());
			map.put(HrObjectsConstraintsEDM.tenantId, dataModel.getTenant());
			map.put(HrObjectsConstraintsEDM.timeConstraint, dataModel.getTimeConstraint());
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	
	}

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}
}
