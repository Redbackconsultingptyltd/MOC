package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

 

public class HrObjectsRelBL extends BaseBL{
private HrObjectRelDAO dao=new HrObjectRelDAO();
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

Hrobjectrel entity=dao.getByPK((HrobjectrelPK)primaryKey);
dao.delete(entity);
return true;
	
}

@Override
public IDBEntity createData(IDBEntity data) {
	try {
		Hrobjectrel entity = (Hrobjectrel) data;
		HrobjectrelPK pk= new HrobjectrelPK();
		//pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
	pk.setTenants_idTenants(entity.getId().getTenants_idTenants());
	pk.setIdsobjectype(entity.getId().getIdobjectype());
	pk.setIdrelatType(entity.getId().getIdrelatType());
	pk.setIdsobjectype(entity.getId().getIdsobjectype());
	pk.setTimeConstraints(entity.getId().getTimeConstraints());
		entity.setId(pk);
		entity =dao.saveNew(entity);
	return entity;
	} catch (Exception e) {
		return null;
	}
	
}

@Override
public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
	try {
		Hrobjectrel founddEntity =dao.getByPK((HrobjectrelPK) pk);
		Hrobjectrel newEntity= (Hrobjectrel) entity;
		
	
		founddEntity.setTableId(newEntity.getTableId());
		founddEntity.setId(newEntity.getId());
		founddEntity.setHrObjectsId(newEntity.getHrObjectsId());
		founddEntity.setHrobject1(newEntity.getHrobject1());
		founddEntity.setHrobject2(newEntity.getHrobject2());
		
		founddEntity = dao.save(founddEntity);
		
		return founddEntity;
	} catch (Exception e) {
	
		
		return entity;
	}
}
 
}
