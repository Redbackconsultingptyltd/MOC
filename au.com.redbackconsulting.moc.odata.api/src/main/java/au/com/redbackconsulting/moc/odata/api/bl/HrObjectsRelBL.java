package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.model.CaSystems;
import au.com.redbackconsulting.moc.persistence.model.CaSystemsPk;
import au.com.redbackconsulting.moc.persistence.model.HrObjectRel;
import au.com.redbackconsulting.moc.persistence.model.HrObjectRelPK;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;

public class HrObjectsRelBL extends BaseBL{

	public HrObjectsRelBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrObjectRelDAO dao = new HrObjectRelDAO();
		List<HrObjectRel> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			HrObjectRel caSystems = (HrObjectRel) iterator.next();
			Map<String, Object> map = convertData(caSystems);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {

		HrObjectRelPK pk = (HrObjectRelPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectRelDAO dao = new HrObjectRelDAO();
		HrObjectRel entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( HrObjectRel dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectRelEDM.objectType, dataModel.getObjectType());
			map.put(HrObjectRelEDM.relatType, dataModel.getRelatType());
			map.put(HrObjectRelEDM.sObjectType, dataModel.getSObjectType());
			map.put(HrObjectRelEDM.tenantId, dataModel.getTenantId());
			map.put(HrObjectRelEDM.timeConstraint, dataModel.getTimeConstraint());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

}
