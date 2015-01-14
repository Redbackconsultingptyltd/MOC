package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.model.CaSystems;
import au.com.redbackconsulting.moc.persistence.model.CaSystemsPk;
import au.com.redbackconsulting.moc.persistence.model.HrHier;
import au.com.redbackconsulting.moc.persistence.model.HrHierPk;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;


import au.com.redbackconsulting.moc.persistence.model.IPkModel;
 

 

public class HrHierBL extends BaseBL{

	public HrHierBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrHierDAO dao = new HrHierDAO();
		List<HrHier> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			HrHier hrhier = (HrHier) iterator.next();
			Map<String, Object> map = convertData(hrhier);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
		
	
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		// TODO Auto-generated method stub
		HrHierPk pk = (HrHierPk) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierDAO dao = new HrHierDAO();
		HrHier entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( HrHier dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrHierEDM.hierId, dataModel.getHierId());
			map.put(HrHierEDM.hierDesc, dataModel.getHierDesc());
			map.put(HrHierEDM.tenantId, dataModel.getTenantId());
			map.put(HrHierEDM.hrHierMap, dataModel.getHrHierMap());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

}
