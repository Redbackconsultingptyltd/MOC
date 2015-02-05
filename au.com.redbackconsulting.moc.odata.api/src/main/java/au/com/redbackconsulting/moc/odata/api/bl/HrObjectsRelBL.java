package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

 

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
		List<Hrobjectrel> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrobjectrel caSystems = (Hrobjectrel) iterator.next();
			Map<String, Object> map = convertData(caSystems);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {

		HrobjectrelPK pk = (HrobjectrelPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectRelDAO dao = new HrObjectRelDAO();
			Hrobjectrel entity =	dao.getByPK(pk);
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
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
private Map<String, Object> convertData( Hrobjectrel dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectRelEDM.objectType, dataModel.getId().getIdobjectype());
			map.put(HrObjectRelEDM.relatType, dataModel.getId().getIdrelatType());
			map.put(HrObjectRelEDM.sObjectType, dataModel.getId().getIdsobjectype());
			map.put(HrObjectRelEDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HrObjectRelEDM.timeConstraint, dataModel.getId().getTimeConstraints());
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

@Override
public IDBEntity createData(IDBEntity entity) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
	// TODO Auto-generated method stub
	return null;
}
 
}
