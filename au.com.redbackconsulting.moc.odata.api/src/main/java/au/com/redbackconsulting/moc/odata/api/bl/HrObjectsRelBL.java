package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTSREL;

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
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

 

public class HrObjectsRelBL extends BaseBL{
private HrObjectRelDAO dao=new HrObjectRelDAO();
	public HrObjectsRelBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}


	private  List<IDBEntity> getDataSet() {
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrObjectRelDAO dao = new HrObjectRelDAO();
		List<Hrobjectrel> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		} catch (Exception e) {
			
		}
		return result;
	}

	private  IDBEntity getData(IPkModel primaryKeyModel) {

		HrobjectrelPK pk = (HrobjectrelPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectRelDAO dao = new HrObjectRelDAO();
			Hrobjectrel entity =	dao.getByPK(pk);
		 
		return (IDBEntity) entity;
		} catch (Exception e) {
			int i =0;
			i=i+1;
		}
		
		return null;
	}
	
 

	private  List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
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

private  boolean deleteData(IPkModel primaryKey) {

Hrobjectrel entity=dao.getByPK((HrobjectrelPK)primaryKey);
dao.delete(entity);
return true;
	
}

private  IDBEntity createData(IDBEntity data) {
	try {
		Hrobjectrel entity = (Hrobjectrel) data;
//		HrobjectrelPK pk= new HrobjectrelPK();
//		//pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
//	pk.setTenants_idTenants(entity.getId().getTenants_idTenants());
//	pk.setIdsobjectype(entity.getId().getIdobjectype());
//	pk.setIdrelatType(entity.getId().getIdrelatType());
//	pk.setIdsobjectype(entity.getId().getIdsobjectype());
//	pk.setTimeConstraints(entity.getId().getTimeConstraints());
//		entity.setId(pk);
	
		entity =dao.saveNew(entity);
	return entity;
	} catch (Exception e) {
		return null;
	}
	
}

private   IDBEntity updateData(IPkModel pk, IDBEntity entity) {
	try {
		Hrobjectrel founddEntity =dao.getByPK((HrobjectrelPK) pk);
		Hrobjectrel newEntity= (Hrobjectrel) entity;
		
	
		founddEntity.setTableId(newEntity.getTableId());
//		founddEntity.setId(newEntity.getId());
		founddEntity.setHrObjectsId(newEntity.getHrObjectsId());
//		founddEntity.setHrobject1(newEntity.getHrobject1());
//		founddEntity.setHrobject2(newEntity.getHrobject2());
//		
		founddEntity = dao.save(founddEntity);
		
		return founddEntity;
	} catch (Exception e) {
	
		
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

private  IPkModel EdmToPK(UriInfo uri) {

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


private    List<Map<String, Object>> convertModelToEDMCollection(
		List<IDBEntity> entities) {
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Hrobjectrel idbEntity = (Hrobjectrel) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobjectrel) entity);
	
	 
}



private  IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {



	int tenantId = (Integer) edm.get(HrObjectRelEDM.tenantId);
	String objectType = (String) edm.get(HrObjectRelEDM.objectType);
	String relatType = (String) edm.get(HrObjectRelEDM.relatType);
	String sObjectType = (String) edm.get(HrObjectRelEDM.sObjectType);
	String timeConstraint = (String) edm.get(HrObjectRelEDM.timeConstraint);
	
	Hrobjectrel entity = new Hrobjectrel();
//	entity.setTimeConstraint(timeConstraint);
	//entity.setTableId(tableId);
	
	
	return null;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	PKFactory pkFactory =PKFactory.getInstance();
	int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
	int hrobjectsId = (Integer) data.get(HrObjectRelEDM.hrobjectsId);
	int objectType = (Integer) data.get(HrObjectRelEDM.objectType);
	String relatType = (String ) data.get(HrObjectRelEDM.relatType);
	int sobjecType = (Integer) data.get(HrObjectRelEDM.sObjectType);
	String tableId = (String) data.get(HrObjectRelEDM.tableId);
	int timeConstraing = (Integer) data.get(HrObjectRelEDM.timeConstraint);	
 
	
	
	TenantsDAO tenantDao = new TenantsDAO();
	TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
	tenantPK.setId(tenantId);
	Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
	
	
	HrobjectrelPK pk  = (HrobjectrelPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTSREL);
	pk.setTenants_idTenants(tenantId);
	pk.setIdobjectype(objectType);
	pk.setIdrelatType(relatType);
 
	pk.setIdsobjectype(sobjecType);
	pk.setTimeConstraints(timeConstraing);
	
	Hrobjectrel entity = new Hrobjectrel();
	entity.setId(pk);

	entity.setTableId(tableId);
	entity.setHrObjectsId(hrobjectsId);
	Hrobjectrel resultEntity =dao.saveNew(entity);
	return convertModelToEDM(resultEntity);
	
	
	
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	PKFactory pkFactory=   PKFactory.getInstance();
	
	try {
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkObjectType =getKeyValue(uriInfo.getKeyPredicates().get(1));
		int pkTimeConstraints =getKeyValue(uriInfo.getKeyPredicates().get(2));
		int pkSObjectType =getKeyValue(uriInfo.getKeyPredicates().get(3));
		String pkRelatType =getKeyValueString(uriInfo.getKeyPredicates().get(4));
			
		HrobjectrelPK pk =  (HrobjectrelPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTSREL);
		pk.setIdobjectype(pkObjectType);
		pk.setIdrelatType(pkRelatType);
		pk.setIdsobjectype(pkSObjectType);
		pk.setTenants_idTenants(pkTenantId);
		pk.setTimeConstraints(pkTimeConstraints);
		
		int hrObjectsId = (Integer) data.get(HrObjectRelEDM.hrobjectsId);
		String tableId = (String) data.get(HrObjectRelEDM.tableId);
	 
		
	 
		
		Hrobjectrel entity = dao.getByPK(pk);
		entity.setHrObjectsId(hrObjectsId);
		entity.setTableId(tableId);
		entity =dao.save(entity);
		dao.refresh(entity);
		return convertModelToEDM(entity);
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
}

 

@Override
public Map<String, Object> read(GetEntityUriInfo uriInfo) {
	try { 
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int objectType = getKeyValue(uriInfo.getKeyPredicates().get(1));
		int timeConstraints = getKeyValue(uriInfo.getKeyPredicates().get(2));
		int sObjectType = getKeyValue(uriInfo.getKeyPredicates().get(3));
		String relatType = getKeyValueString(uriInfo.getKeyPredicates().get(4));
		
		
		
		

		HrobjectrelPK pk = (HrobjectrelPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTSREL);
		pk.setIdobjectype(objectType);
		pk.setIdrelatType(relatType);
		pk.setIdsobjectype(sObjectType);
		pk.setTenants_idTenants(tenantId);
		pk.setTimeConstraints(timeConstraints);
		// Map<String, Object> data = blModel.getData(pk);
		IDBEntity entity =  getData(pk);
		Map<String, Object> data =  convertModelToEDM(entity);
		return data;
	} catch (Exception e) {
		return null;
	}
}

@Override
public List<Map<String, Object>> readSet() {
	try {
		List<IDBEntity> entities = getDataSet();
		List<Map<String, Object>> data = convertModelToEDMCollection(entities);
		return data;
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return null;
}

 

@Override
public boolean delete(DeleteUriInfo uriInfo) {
	try {
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkObjectType =getKeyValue(uriInfo.getKeyPredicates().get(1));
		int pkTimeConstraints =getKeyValue(uriInfo.getKeyPredicates().get(2));
		int pkSObjectType =getKeyValue(uriInfo.getKeyPredicates().get(3));
		String pkRelatType =getKeyValueString(uriInfo.getKeyPredicates().get(4));
	
		 
		HrobjectrelPK pk = (HrobjectrelPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTSREL);
		pk.setIdobjectype(pkObjectType);
		pk.setIdrelatType(pkRelatType);
		pk.setIdsobjectype(pkSObjectType);
		pk.setTenants_idTenants(pkTenantId);
		pk.setTimeConstraints(pkTimeConstraints);
		
		boolean status =  deleteData(pk);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}

}
