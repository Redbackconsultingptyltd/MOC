package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HRP1000EDM;
import au.com.redbackconsulting.moc.persistence.HRP1000DAO;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class HRP1000BL extends BaseBL {

	public HRP1000BL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {


		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HRP1000DAO dao = new HRP1000DAO();
		
		    List<Hrp1000> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrp1000 hrObjectConstraints = (Hrp1000) iterator.next();
			Map<String, Object> map = convertData(hrObjectConstraints);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {

		Hrp1000PK pk = (Hrp1000PK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HRP1000DAO dao = new HRP1000DAO();
			Hrp1000 entity =	dao.getByPK(pk);
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
	
private Map<String, Object> convertData( Hrp1000 dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HRP1000EDM.changedBy, dataModel.getChangedBy());
			map.put(HRP1000EDM.changedOn, dataModel.getChangedOn());
			map.put(HRP1000EDM.guid, dataModel.getGuid());
			//map.put(HRP1000EDM.tenantId, dataModel.get);
			map.put(HRP1000EDM.hrObjectsStatus, dataModel.getHrobjectsstatus());
			map.put(HRP1000EDM.objectDesc, dataModel.getObjectDesc());
			map.put(HRP1000EDM.objectId, dataModel.getId());
			map.put(HRP1000EDM.objectType, dataModel.getId().getIdobjectType());
			map.put(HRP1000EDM.seqNr, dataModel.getSeqNo());
			map.put(HRP1000EDM.status, dataModel.getId().getStatus());
			map.put(HRP1000EDM.stext, dataModel.getStext());
			map.put(HRP1000EDM.validFrom, dataModel.getId().getValidFrom());
			map.put(HRP1000EDM.validTo, dataModel.getId().getValidTo());
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
