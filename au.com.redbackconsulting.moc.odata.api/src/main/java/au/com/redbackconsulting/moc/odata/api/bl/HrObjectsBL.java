package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.model.HrObjectRel;
import au.com.redbackconsulting.moc.persistence.model.HrObjectRelPK;
import au.com.redbackconsulting.moc.persistence.model.HrObjects;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsPk;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;

public class HrObjectsBL extends BaseBL {

	public HrObjectsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrObjectsDAO dao = new HrObjectsDAO();
		List<HrObjects> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			HrObjects hrobjects = (HrObjects) iterator.next();
			Map<String, Object> map = convertData(hrobjects);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {

		HrObjectsPk pk = (HrObjectsPk) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsDAO dao = new HrObjectsDAO();
		HrObjects entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( HrObjects dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsEDM.objectType, dataModel.getObjectType());
			map.put(HrObjectsEDM.sObjectType, dataModel.getSObjectType());
			map.put(HrObjectsEDM.systId, dataModel.getSystId());
			map.put(HrObjectsEDM.tenantId, dataModel.getTenantId());
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

}
