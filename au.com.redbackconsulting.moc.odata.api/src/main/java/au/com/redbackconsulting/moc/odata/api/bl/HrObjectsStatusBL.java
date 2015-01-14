package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsStatusEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectsConstraintsDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsStatusDAO;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsConstraints;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsConstraintsPk;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsStatus;
import au.com.redbackconsulting.moc.persistence.model.HrObjectsStatusPk;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;
 

public class HrObjectsStatusBL extends BaseBL {

	public HrObjectsStatusBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
 
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrObjectsStatusDAO dao = new HrObjectsStatusDAO();
		//CaSystemsDAO dao = new CaSystemsDAO();
		    List<HrObjectsStatus> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			HrObjectsStatus hrObjectConstraints = (HrObjectsStatus) iterator.next();
			Map<String, Object> map = convertData(hrObjectConstraints);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return null;
	}
private Map<String, Object> convertData( HrObjectsStatus dataModel){
		/*remark*/
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put(HrObjectsConstraintsEDM.tenantId, dataModel.get);
			map.put(HrObjectsStatusEDM.description, dataModel.getDescription());
			map.put(HrObjectsStatusEDM.hRP1000, dataModel.getHRP1000());
			map.put(HrObjectsStatusEDM.hRP1001, dataModel.getHRP1001());
			map.put(HrObjectsStatusEDM.status, dataModel.getStatus());
		
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		HrObjectsStatusPk pk = (HrObjectsStatusPk) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsStatusDAO dao = new HrObjectsStatusDAO();
			HrObjectsStatus entity =	dao.getByPK(pk);
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

}
