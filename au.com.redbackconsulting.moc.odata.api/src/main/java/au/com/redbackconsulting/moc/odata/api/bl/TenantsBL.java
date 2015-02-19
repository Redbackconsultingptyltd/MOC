package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_TENANTS;

import java.util.ArrayList;
import java.util.Collection;
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

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.TenantsEDM;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class TenantsBL extends BaseBL {

	private TenantsDAO dao = new TenantsDAO();

	public TenantsBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}


	private  List<IDBEntity> getDataSet() {
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			TenantsDAO dao = new TenantsDAO();
			List<Tenant> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
		} catch (Exception e) {
			int i = 8;
		}
		return result;

	}


	private  IDBEntity getData(IPkModel primaryKeyModel) {

		TenantPK pk = (TenantPK) primaryKeyModel;
	 
		try {

			Tenant entity = dao.getByPK(pk);
		
			return entity;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

		return null;
	}

	private Map<String, Object> convertData(Tenant entity) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(TenantsEDM.tenantId, entity.getTenantPK().getId());
			map.put(TenantsEDM.name, entity.getName());
			map.put(TenantsEDM.tenantCode, entity.getTenantsCode());
			return map;

		} catch (Exception e) {
			return null;
		}
	}


	private   List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		TenantPK pk = (TenantPK) primaryKey;

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			TenantsDAO dao = new TenantsDAO();
			Tenant entity = dao.getByPK(pk);
			Collection<Casystem> collection = entity.getCasystems();
			for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
				Casystem caSystems = (Casystem) iterator.next();
				Map<String, Object> map = convertCaSystem(caSystems);
				result.add(map);
			}

			return result;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}
		return null;
	}

	private Map<String, Object> convertCaSystem(Casystem caSystems) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(CaSystemEDM.SYSID, caSystems.getId().getIdsys());
		map.put(CaSystemEDM.SYSDESC, caSystems.getSysdesc());
		map.put(CaSystemEDM.TENANTID, caSystems.getId().getTenants_idTenants());
		return map;
	}


	private  boolean deleteData(IPkModel primaryKey) {
		Tenant entity = dao.getByPK((TenantPK) primaryKey);
		dao.delete(entity);
		return true;
	}

	private  IDBEntity createData(IDBEntity data) {
		try {
			Tenant entity = (Tenant) data;
		
			entity = dao.saveNew(entity);
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	private  IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Tenant founddEntity = dao.getByPK((TenantPK) pk);
			Tenant newEntity = (Tenant) entity;

//			founddEntity.setCasystems(newEntity.getCasystems());
//			founddEntity.setHrhiermaps(newEntity.getHrhiermaps());
//			founddEntity.setHrhiers(newEntity.getHrhiers());
//			founddEntity.setHrobjects(newEntity.getHrobjects());
			founddEntity.setName(newEntity.getName());
			founddEntity.setTenantsCode(newEntity.getTenantsCode());
			founddEntity = dao.save(founddEntity);
			dao.refresh(founddEntity);

			return founddEntity;
		} catch (Exception e) {
			return null;
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

	 



private  List<Map<String, Object>> convertModelToEDMCollection(
		List<IDBEntity> entities) {
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Tenant idbEntity = (Tenant) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Tenant) entity);
	
	 
}


private   IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {

	int tenantId = (Integer) edm.get(TenantsEDM.tenantId);
	String name = (String) edm.get(TenantsEDM.name);
	String tenantsCode = (String) edm.get(TenantsEDM.tenantCode);
	
	
	TenantPK pk = (TenantPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_TENANTS);
	pk.setId(tenantId);
	Tenant entity = new Tenant();
entity.setName(name);
entity.setTenantsCode(tenantsCode);
entity.setTenantPK(pk);
	

	return entity;
}


@Override
public Map<String, Object> createNew(Map<String, Object> data) {
try {
 

	TenantPK  pk = (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
	
	Tenant entity = (Tenant)  convertEDMDataToModelEDM(data);
	
	entity = (Tenant) createData(entity);
	return convertModelToEDM(entity);
} catch (Exception e) {
	// TODO: handle exception
}
	return null;
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	try { 
		//Read PK from URL
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(0));
		TenantPK pk = new TenantPK();
		pk.setId(pkTenantId);

		
		//Read Form Data
		Tenant entity = (Tenant)  convertEDMDataToModelEDM(data);
		
 		entity = (Tenant) updateData(pk, entity);
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
	 	TenantPK pk =  (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
		pk.setId((tenantId));
		IDBEntity entity =  getData(pk);
		Map<String, Object> data = convertModelToEDM(entity);
		return data;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
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
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

	 	TenantPK pk =  (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
		pk.setId((tenantId));
		boolean status =  deleteData(pk);
		return status;

	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}
}
