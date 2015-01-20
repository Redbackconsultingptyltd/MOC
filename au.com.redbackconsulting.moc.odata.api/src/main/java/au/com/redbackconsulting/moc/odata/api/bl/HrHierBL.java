package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
 

 

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
		List<Hrhier> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrhier hrhier = (Hrhier) iterator.next();
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
		HrhierPK pk = (HrhierPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierDAO dao = new HrHierDAO();
		Hrhier entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( Hrhier dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrHierEDM.hierId, dataModel.getId().getIdHrHier());
			map.put(HrHierEDM.hierDesc, dataModel.getHierdesc());
			map.put(HrHierEDM.tenantId, dataModel.getId().getTenants_idTenants());
//			map.put(HrHierEDM.hrHierMap, dataModel.getHrHierMap());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

}
