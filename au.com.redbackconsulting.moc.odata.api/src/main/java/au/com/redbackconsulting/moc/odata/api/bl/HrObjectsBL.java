package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

 
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
		List<Hrobject> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrobject hrobjects = (Hrobject) iterator.next();
			Map<String, Object> map = convertData(hrobjects);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

	 
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		// TODO Auto-generated method stub
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
 
	
private Map<String, Object> convertData( Hrobject dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsEDM.objectType, dataModel.getId().getIdObjectType());
			map.put(HrObjectsEDM.sObjectType, dataModel.getSObjectType());
			map.put(HrObjectsEDM.systId, dataModel.getId().getIdObjectType());
			map.put(HrObjectsEDM.tenantId, dataModel.getId().getTenants_idTenants());
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	} 

}
