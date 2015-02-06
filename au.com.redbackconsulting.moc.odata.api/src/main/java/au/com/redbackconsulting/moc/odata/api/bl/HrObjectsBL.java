package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

 
public class HrObjectsBL extends BaseBL {
private HrObjectsDAO dao=new HrObjectsDAO();
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

@Override
public boolean deleteData(IPkModel primaryKey) {
	// TODO Auto-generated method stub
	

	Hrobject entity = dao.getByPK((HrobjectPK) primaryKey);
	dao.delete(entity);
	return true;
	
}

@Override
public IDBEntity createData(IDBEntity data) {
	try {
		Hrobject entity = (Hrobject) data;
		HrobjectPK pk= new HrobjectPK();
		pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
		
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
		Hrobject founddEntity =dao.getByPK((HrobjectPK) pk);
		Hrobject newEntity= (Hrobject) entity;
		founddEntity.setCasystem(newEntity.getCasystem());
		founddEntity.setHrobjectsconstraint(newEntity.getHrobjectsconstraint());
		founddEntity.setId(newEntity.getId());
		founddEntity.setTenant(newEntity.getTenant());
		founddEntity = dao.save(founddEntity);
		
		return founddEntity;
	} catch (Exception e) {
		// TODO: handle exception
	
	return entity;
	}
} 

}
