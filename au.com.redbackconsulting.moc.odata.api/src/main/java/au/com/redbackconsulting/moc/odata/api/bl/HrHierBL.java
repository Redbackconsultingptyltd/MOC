package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIER;

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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.TenantsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;
 

 

public class HrHierBL extends BaseBL{
	
	
	
 
	@Override
	public boolean delete(DeleteUriInfo uriInfo) {
		try {
			int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
			
			HrhierPK pk =  (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
			pk.setIdHrHier(id);
			pk.setTenants_idTenants(tenantId);
			boolean status = deleteData(pk);
			return status;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public HrHierBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> read(GetEntityUriInfo uriInfo) {
		try {
			int hierId = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
		 	HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
			pk.setIdHrHier(hierId);
			pk.setTenants_idTenants(tenantId);
			// Map<String, Object> data = blModel.getData(pk);
			IDBEntity entity = getData(pk);
			Map<String, Object> data =  convertModelToEDM(entity);
			return data;
		} catch (Exception e) {
			// TODO: handle exception
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

	private HrHierDAO dao = new HrHierDAO();
	

	private List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub
		
		List<IDBEntity> result = new ArrayList<IDBEntity>();
 
			HrHierDAO dao = new HrHierDAO();
		List<Hrhier> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		
	
	}

	private IDBEntity getData(IPkModel primaryKeyModel) {
		// TODO Auto-generated method stub
		HrhierPK pk = (HrhierPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrHierDAO dao = new HrHierDAO();
		Hrhier entity =	dao.getByPK(pk);
	return entity;
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
	
private Map<String, Object> convertData( Hrhier dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrHierEDM.hierId, dataModel.getId().getIdHrHier());
			map.put(HrHierEDM.hierDesc, dataModel.getHierdesc());
			map.put(HrHierEDM.tenantId, dataModel.getId().getTenants_idTenants());
//			map.put(HrHierEDM.hrHierMap, dataModel.getHrHierMap());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

private  boolean deleteData(IPkModel primaryKey) {

	Hrhier entity = dao.getByPK((HrhierPK) primaryKey);
	dao.delete(entity);
	return true;
}

private  IDBEntity createData(IDBEntity data) {
	try {
		Hrhier entity = (Hrhier) data;
	
	
	
			entity =dao.saveNew(entity);
	return entity;
	} catch (Exception e) {
		return null;
	}
	
}
private  IDBEntity updateData(IPkModel pk, IDBEntity entity) {
	// TODO Auto-generated method stub


	try {
		Hrhier founddEntity =dao.getByPK((HrhierPK) pk);
		Hrhier newEntity= (Hrhier) entity;
		founddEntity.setHierdesc(newEntity.getHierdesc());
		founddEntity.setHiershortdesc(newEntity.getHiershortdesc());
		founddEntity.setTenant(newEntity.getTenant());
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

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrhier) entity);
	
	 
}

private  List<Map<String, Object>>  convertModelToEDMCollection(List<IDBEntity> entities){
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Hrhier idbEntity = (Hrhier) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
	 
}


private  IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {


	int tenantId = (Integer) edm.get(HrHierEDM.tenantId);
	String hierDesc = (String) edm.get(HrHierEDM.hierDesc);
int hierId=(Integer)edm.get(HrHierEDM.hierId);
//int Hrhiermap=(Integer)edm.get(HrHierEDM.hrHierMap);
HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRHIER);

	pk.setIdHrHier(hierId);
	pk.setTenants_idTenants(tenantId);
	TenantPK tenantPk = (TenantPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_TENANTS);
	Tenant tenant = new Tenant();
	tenant.setTenantPK(tenantPk);
	tenantPk.setId(tenantId);
	Hrhier entity = new Hrhier();
	
	entity.setHierdesc(hierDesc);
	entity.setId(pk);
	entity.setTenant(tenant);
	
	
	
	
	return entity;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	try {
		int tenantId = (Integer) data.get(HrHierEDM.tenantId);
//		int hierId = (Integer) data.get(HrHierEDM.hierId);
		String hierDesc = (String) data.get(HrHierEDM.hierDesc);
		HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
//		HrhierPK pk = new HrhierPK();
		pk.setTenants_idTenants(tenantId);
//		pk.setIdHrHier(hierId);
		Hrhier entity = (Hrhier)  convertEDMDataToModelEDM(data);

		
		entity.setHierdesc(hierDesc);
		entity.getId().setIdHrHier(0);
		 entity =(Hrhier) createData(entity);
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
		
		int hierId = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
		HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
		pk.setIdHrHier(hierId);
		pk.setTenants_idTenants(tenantId);
	
		 
						
		//Read Form Data
		Hrhier entity =   (Hrhier)  convertEDMDataToModelEDM(data);
		entity =  (Hrhier)  updateData(pk, entity);
		return convertModelToEDM(entity);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}



}
