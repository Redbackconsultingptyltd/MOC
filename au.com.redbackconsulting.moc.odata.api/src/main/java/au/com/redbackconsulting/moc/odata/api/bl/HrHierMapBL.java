package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.UriInfo;
import org.eclipse.persistence.internal.jpa.jpql.HermesParser;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HrHierMapBL extends BaseBL {

	private HrHierMapDAO dao=new HrHierMapDAO();
	public HrHierMapBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
		List<Hrhiermap> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		 
		} catch (Exception e) {
			
		}
		return result;
		
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {
 
		HrhiermapPK pk = (HrhiermapPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
			Hrhiermap entity =	dao.getByPK(pk);
		result= convertData(entity);
		return (IDBEntity) result;
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

private int getKeyValue(KeyPredicate key) throws ODataException {
	EdmProperty property = key.getProperty();
	EdmSimpleType type = (EdmSimpleType) property.getType();
	return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
			property.getFacets(), Integer.class);
}

private String getKeyValueString(KeyPredicate key) throws ODataException {
	EdmProperty property = key.getProperty();
	EdmSimpleType type = (EdmSimpleType) property.getType();
	return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
			property.getFacets(), String.class);
}

public IPkModel EdmToPK(UriInfo uri) {

	try {
		TenantPK tenantPk = new TenantPK();
		int id = getKeyValue(uri.getKeyPredicates().get(0));
		String idstr = getKeyValueString(uri.getKeyPredicates().get(1));

		tenantPk.setId(id);

	} catch (Exception e) {
		// TODO: handle exception
	}

	return null;
}




@Override
public List<Map<String, Object>> convertModelToEDMCollection(
		List<IDBEntity> entities) {
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Hrhiermap idbEntity = (Hrhiermap) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrhiermap) entity);
	
	 
}

@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
	// TODO Auto-generated method stub
	return null;
}
 
}
