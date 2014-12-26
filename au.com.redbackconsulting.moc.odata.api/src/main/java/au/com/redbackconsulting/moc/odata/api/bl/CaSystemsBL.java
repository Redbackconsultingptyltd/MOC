package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.model.CaSystems;

public class CaSystemsBL   implements IBLModel{

 
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			CaSystemsDAO dao = new CaSystemsDAO();
		List<CaSystems> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			CaSystems caSystems = (CaSystems) iterator.next();
			Map<String, Object> map = convertData(caSystems);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

 
	public Map<String, Object> getData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

 
	public boolean deleteData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return false;
	}

 
	public Map<String, Object> updateData(Map<String, Object> valueMap,
			Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

 
	public Map<String, Object> createData(Map<String, Object> valueMap) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> convertData( CaSystems dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(CaSystemEDM.SYSID, dataModel.getSystId());
			map.put(CaSystemEDM.SYSDESC, dataModel.getSystDesc());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}
	

}
