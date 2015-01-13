package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.model.CaSystems;
import au.com.redbackconsulting.moc.persistence.model.CaSystemsPk;
import au.com.redbackconsulting.moc.persistence.model.HrHier;
import au.com.redbackconsulting.moc.persistence.model.HrHierMap;
import au.com.redbackconsulting.moc.persistence.model.HrHierMapPk;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;

public class HrHierMapBL extends BaseBL {

	public HrHierMapBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		// TODO Auto-generated method stub

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
		List<HrHierMap> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			HrHierMap hrhiemap = (HrHierMap) iterator.next();
			Map<String, Object> map = convertData(hrhiemap);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
		
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		HrHierMapPk pk = (HrHierMapPk) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
		HrHierMap entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( HrHierMap dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrHierMapEDM.hierId, dataModel.getHierId());
			map.put(HrHierMapEDM.objectType, dataModel.getObjectType());
			map.put(HrHierMapEDM.relatType, dataModel.getRelatType());
			map.put(HrHierMapEDM.seqNo, dataModel.getSeqNo());
			map.put(HrHierMapEDM.skip, dataModel.getSkip());
			map.put(HrHierMapEDM.sObjType, dataModel.getSObjType());
			map.put(HrHierMapEDM.tenantId, dataModel.getTenantId());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

}
