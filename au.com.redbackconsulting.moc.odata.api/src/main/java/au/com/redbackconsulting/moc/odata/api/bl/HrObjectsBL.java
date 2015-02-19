package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTS;

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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HRP1000DAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

 
public class HrObjectsBL extends BaseBL {
private HrObjectsDAO dao=new HrObjectsDAO();
	public HrObjectsBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}


	private  List<IDBEntity> getDataSet() {
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrObjectsDAO dao = new HrObjectsDAO();
		List<Hrobject> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		} catch (Exception e) {
			
		}
		return result;
	}

	 
	public IDBEntity getData(IPkModel primaryKeyModel) {

		HrobjectPK pk = (HrobjectPK) primaryKeyModel;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			HrObjectsDAO dao = new HrObjectsDAO();
			Hrobject entity = dao.getByPK(pk);
		 
			return (IDBEntity) entity;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

		return null;
	}

	

 
 

	private  List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
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

private  boolean deleteData(IPkModel primaryKey) {
	// TODO Auto-generated method stub
	

	Hrobject entity = dao.getByPK((HrobjectPK) primaryKey);
	dao.delete(entity);
	return true;
	
}

private  IDBEntity createData(IDBEntity data) {
	try {
		Hrobject entity = (Hrobject) data;
		
		
//		HrobjectPK pk= new HrobjectPK();
//		pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
//		
//		entity.setId(pk);
		entity =dao.saveNew(entity);
	return entity;
	} catch (Exception e) {
		return null;
	}
	
}

private   IDBEntity updateData(IPkModel pk, IDBEntity entity) {
	try {
		Hrobject founddEntity =dao.getByPK((HrobjectPK) pk);
		Hrobject newEntity= (Hrobject) entity;
//		founddEntity.setCasystem(newEntity.getCasystem());
//		founddEntity.setHrobjectsconstraint(newEntity.getHrobjectsconstraint());
//		founddEntity.setId(newEntity.getId());
//		founddEntity.setTenant(newEntity.getTenant());
		
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

private IPkModel EdmToPK(UriInfo uri) {

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



private   List<Map<String, Object>> convertModelToEDMCollection(
		List<IDBEntity> entities) {
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Hrobject idbEntity = (Hrobject) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobject) entity);
	
	 
}



private   IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {



	int tenantId = (Integer) edm.get(HrObjectsEDM.tenantId);
	int systId = (Integer) edm.get(HrObjectsEDM.systId);
	String sObjectType = (String) edm.get(HrObjectsEDM.sObjectType);
	String objectType = (String) edm.get(HrObjectsEDM.objectType);
	
	
	Hrobject entity = new Hrobject();
	entity.setSObjectType(sObjectType);
	
	
	
	return null;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	PKFactory pkfactory =PKFactory.getInstance();
	int tenantId = (Integer) data.get(HrObjectsEDM.tenantId);
	int systId = (Integer) data.get(HrObjectsEDM.systId);
	String sObjectType = (String) data.get(HrObjectsEDM.sObjectType);
//	String objectType = (String) data.get(HrObjectsEDM.objectType);
	
	CaSystemsDAO caSystemDao = new CaSystemsDAO();
	CasystemPK caSystemsPk = (CasystemPK)pkfactory.getPKModel(Constants.PERSISTENCE_CASYSTEMS);
	caSystemsPk.setIdsys(systId);
	caSystemsPk.setTenants_idTenants(tenantId);
	Casystem caSystemEntity =caSystemDao.getByPK(caSystemsPk);
	
	TenantsDAO tenantDao = new TenantsDAO();
	TenantPK tenantPK = (TenantPK) pkfactory.getPKModel(Constants.PERSISTENCE_TENANTS);
	tenantPK.setId(tenantId);
	Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
	
	
	HrobjectPK pk = (HrobjectPK) pkfactory.getPKModel(Constants.PERSISTENCE_HROBJECTS);
	pk.setTenants_idTenants(tenantId);
	Hrobject entity = new Hrobject();
	entity.setId(pk);
	entity.setCasystem(caSystemEntity);
	entity.setSObjectType(sObjectType);
	entity.setTenant(tenantEntity);
	
	Hrobject resultEntity =dao.saveNew(entity);
	return convertModelToEDM(resultEntity);
	
	
	
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	try {
		int objectType =getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
		PKFactory pkFactory=   PKFactory.getInstance();
		
		HrobjectPK pk =(HrobjectPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTS);
		pk.setIdObjectType(objectType);
		pk.setTenants_idTenants(pkTenantId);
		
		
		int systId = (Integer) data.get(HrObjectsEDM.systId);
		String sObjectType = (String) data.get(HrObjectsEDM.sObjectType);
	 
		
		CaSystemsDAO caSystemDao = new CaSystemsDAO();
		CasystemPK caSystemsPk = (CasystemPK)pkFactory.getPKModel(Constants.PERSISTENCE_CASYSTEMS);
		caSystemsPk.setIdsys(systId);
		caSystemsPk.setTenants_idTenants(pkTenantId);
		Casystem caSystemEntity =caSystemDao.getByPK(caSystemsPk);
		
		TenantsDAO tenantDao = new TenantsDAO();
		TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
		tenantPK.setId(pkTenantId);
		Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
		
		Hrobject entity = dao.getByPK(pk);
		entity.setSObjectType(sObjectType);
		entity.setTenant(tenantEntity);
		entity.setCasystem(caSystemEntity);
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
		int objectType  = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
		 HrobjectPK pk = (HrobjectPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTS);
		pk.setIdObjectType(objectType);
		pk.setTenants_idTenants(tenantId);
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
		int objectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
		 
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
 
		HrobjectPK pk =  (HrobjectPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTS);
		
		pk.setIdObjectType(objectType);
		pk.setTenants_idTenants(tenantId);
		boolean status =  deleteData(pk);
		return status;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}
 
}
