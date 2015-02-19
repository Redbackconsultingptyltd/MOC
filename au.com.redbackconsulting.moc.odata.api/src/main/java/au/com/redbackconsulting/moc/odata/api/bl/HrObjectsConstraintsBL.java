package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTCONSTRAINTS;

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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsConstraintsDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HrObjectsConstraintsBL extends BaseBL{

	private HrObjectsConstraintsDAO dao=new HrObjectsConstraintsDAO();
	public HrObjectsConstraintsBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	private  List<IDBEntity> getDataSet() {


		
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
		List<Hrobjectsconstraint> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		} catch (Exception e) {
			
		}
		return result;
		
	}

	private  IDBEntity getData(IPkModel primaryKeyModel) {


		HrobjectsconstraintPK pk = (HrobjectsconstraintPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
			Hrobjectsconstraint entity =	dao.getByPK(pk);
	 
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
	
	private Map<String, Object> convertData( Hrobjectsconstraint dataModel){

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsConstraintsEDM.objectType, dataModel.getId().getHrObject());
			map.put(HrObjectsConstraintsEDM.tableId, dataModel.getTableId());
			map.put(HrObjectsConstraintsEDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HrObjectsConstraintsEDM.timeConstraint, dataModel.getTimeConstraint());
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	
	}

	private  boolean deleteData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		
		Hrobjectsconstraint entity=dao.getByPK((HrobjectsconstraintPK)primaryKey);
		dao.delete(entity);
		return true;
	}

	private    IDBEntity createData(IDBEntity data) {
		try {
			Hrobjectsconstraint entity = (Hrobjectsconstraint) data;
//			HrobjectsconstraintPK pk= new HrobjectsconstraintPK();
//			pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
//			
//			entity.setId(pk);
			entity =dao.saveNew(entity);
		return entity;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	private   IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Hrobjectsconstraint founddEntity =dao.getByPK((HrobjectsconstraintPK) pk);
			Hrobjectsconstraint newEntity= (Hrobjectsconstraint) entity;
			//founddEntity.setHrobject(newEntity.getHrobject());
			founddEntity.setTableId(newEntity.getTableId());
			founddEntity.setTimeConstraint(newEntity.getTimeConstraint());
			//founddEntity.setTenant(newEntity.getTenant());
			//founddEntity.setId(newEntity.getId());
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
			Hrobjectsconstraint idbEntity = (Hrobjectsconstraint) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobjectsconstraint) entity);
	
	 
}



private   IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {


	int tenantId = (Integer) edm.get(HrObjectsConstraintsEDM.tenantId);
	String objectType = (String) edm.get(HrObjectsConstraintsEDM.objectType);
	int tableId = (Integer) edm.get(HrObjectsConstraintsEDM.tableId);
	String timeConstraint = (String) edm.get(HrObjectsConstraintsEDM.timeConstraint);
	
	
	Hrobjectsconstraint entity = new Hrobjectsconstraint();
//	entity.setTimeConstraint(timeConstraint);
	
	
	
	
	
	
	return null;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	PKFactory pkFactory =PKFactory.getInstance();
	int pkTenantId = (Integer) data.get(HrObjectsConstraintsEDM.tenantId);
	String tableId = (String) data.get(HrObjectsConstraintsEDM.tableId);
	int timeConstraints =(Integer) data.get(HrObjectsConstraintsEDM.timeConstraint);
 	 int pkobjectType =(Integer) data.get(HrObjectsConstraintsEDM.objectType);

	

	
	
	TenantsDAO tenantDao = new TenantsDAO();
	TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
	tenantPK.setId(pkTenantId);
	Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
	
	HrobjectPK hrobjectsPK =(HrobjectPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTS);
	hrobjectsPK.setIdObjectType(pkobjectType);
	hrobjectsPK.setTenants_idTenants(pkTenantId);
	HrObjectsDAO hrobjectDao = new HrObjectsDAO();
	Hrobject hrObjectsEntity =hrobjectDao.getByPK(hrobjectsPK);
	
	
	
	HrobjectsconstraintPK pk = (HrobjectsconstraintPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTCONSTRAINTS);
	pk.setTenants_idTenants(pkTenantId);
	pk.setHrObject(pkobjectType);
	Hrobjectsconstraint entity = new Hrobjectsconstraint();
	entity.setId(pk);
	entity.setTableId(tableId);
	entity.setTimeConstraint(timeConstraints);
entity.setTenant(tenantEntity);	 
entity.setHrobject(hrObjectsEntity);
	Hrobjectsconstraint resultEntity =dao.saveNew(entity);
	return convertModelToEDM(resultEntity);
	
	
	
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	PKFactory pkFactory=   PKFactory.getInstance();
	try {
		int pkobjectType =getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
		
		 
		int tenantId = (Integer) data.get(HrObjectsConstraintsEDM.tenantId);
		String tableId = (String) data.get(HrObjectsConstraintsEDM.tableId);
		int timeConstraints =(Integer) data.get(HrObjectsConstraintsEDM.timeConstraint);
		int hrobjectId =(Integer) data.get(HrObjectsConstraintsEDM.objectType);

		
		
		TenantsDAO tenantDao = new TenantsDAO();
		TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
		tenantPK.setId(tenantId);
		Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
		
		
		
		
		
		HrobjectsconstraintPK pk = (HrobjectsconstraintPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTCONSTRAINTS);
		pk.setHrObject(pkobjectType);
		pk.setTenants_idTenants(pkTenantId);
		
		
		Hrobjectsconstraint entity = dao.getByPK(pk);
		
		entity.setTableId(tableId);
		entity.setTimeConstraint(timeConstraints);
	 
		Hrobjectsconstraint resultEntity =dao.save (entity);
		return convertModelToEDM(resultEntity);
		
	 
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
}

@Override
public Map<String, Object> read(GetEntityUriInfo uriInfo) {
	try {
		int objectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));

		
		 
		HrobjectsconstraintPK  pk = (HrobjectsconstraintPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTCONSTRAINTS);
		pk.setHrObject(objectType);
		pk.setTenants_idTenants(tenantId);
		
		// Map<String, Object> data = blModel.getData(pk);
		IDBEntity entity = getData(pk);
		Map<String, Object> data =  convertModelToEDM(entity);
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
		int hrobjectId = getKeyValue(uriInfo.getKeyPredicates().get(0));

		 
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));

	 
		HrobjectsconstraintPK pk =  (HrobjectsconstraintPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTCONSTRAINTS);
		pk.setHrObject(hrobjectId);
		pk.setTenants_idTenants(tenantId);
		//		pk.setId((tenantId));
		boolean status =  deleteData(pk);
		return status;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
} 

}
