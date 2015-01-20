package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrRelationsEDM;
import au.com.redbackconsulting.moc.persistence.HrRelationsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrrelation;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class HrRelationsBL extends BaseBL {

	public HrRelationsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	
private Map<String, Object> convertData( Hrrelation dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put(HrRelationsEDM.tenantId, dataModel.getSystId());
			map.put(HrRelationsEDM.relatType, dataModel.getId().getRelatType());
			map.put(HrRelationsEDM.relatTypeT, dataModel.getRelatTypeT());
		
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			HrRelationsDAO dao = new HrRelationsDAO();
		List<Hrrelation> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrrelation hrRelations = (Hrrelation) iterator.next();
			Map<String, Object> map = convertData(hrRelations);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
 
		HrrelationPK pk = (HrrelationPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrRelationsDAO dao = new HrRelationsDAO();
			Hrrelation entity =	dao.getByPK(pk);
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
