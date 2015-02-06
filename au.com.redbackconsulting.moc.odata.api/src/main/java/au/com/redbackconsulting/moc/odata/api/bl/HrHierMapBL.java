package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.internal.jpa.jpql.HermesParser;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class HrHierMapBL extends BaseBL {

	private HrHierMapDAO dao=new HrHierMapDAO();
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
		List<Hrhiermap> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Hrhiermap hrhiemap = (Hrhiermap) iterator.next();
			Map<String, Object> map = convertData(hrhiemap);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
		
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
 
		HrhiermapPK pk = (HrhiermapPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
			Hrhiermap entity =	dao.getByPK(pk);
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
 
	
private Map<String, Object> convertData( Hrhiermap dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrHierMapEDM.hierId, dataModel.getId().getHrHierId());
			map.put(HrHierMapEDM.objectType, dataModel.getObjectTypeId());
			map.put(HrHierMapEDM.relatType, dataModel.getRelatType());
			map.put(HrHierMapEDM.seqNo, dataModel.getId().getSeqNo());
			map.put(HrHierMapEDM.skip, dataModel.getSkip());
			map.put(HrHierMapEDM.sObjType, dataModel.getSObjectTypeId());
			map.put(HrHierMapEDM.tenantId, dataModel.getId().getTenants_idTenants());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

@Override
public boolean deleteData(IPkModel primaryKey) {
	// TODO Auto-generated method stub
	Hrhiermap entity = dao.getByPK((HrhiermapPK) primaryKey);
	dao.delete(entity);
	
	return true;
}

@Override
public IDBEntity createData(IDBEntity data) {
	try {
		
		Hrhiermap entity=(Hrhiermap) data;	
		
		
		HrhiermapPK pk= new HrhiermapPK();
		pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
	//pk.setSeqNo(entity.getTenant().getTenantPK().get);
		//pk.setIdHrHier(entity.getTenant().getTenantPK().get);
	
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
	
	Hrhiermap founddEntity =dao.getByPK((HrhiermapPK) pk);
	Hrhiermap newEntity= (Hrhiermap) entity;
	founddEntity.setHrhier(newEntity.getHrhier());          
	founddEntity.setObjectTypeId(newEntity.getObjectTypeId());  
	founddEntity.setTenant(newEntity.getTenant());
	founddEntity.setId(newEntity.getId());
	founddEntity.setRelatType(newEntity.getRelatType());
	founddEntity.setSkip(newEntity.getSkip());
	founddEntity.setSObjectTypeId(newEntity.getSObjectTypeId());
	founddEntity = dao.save(founddEntity);
	return founddEntity;
} catch (Exception e) {
	// TODO: handle exception
	return entity;
}
	

}
 
}
