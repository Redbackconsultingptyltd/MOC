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
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsStatusEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsStatusDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsstatus;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;
 

public class HrObjectsStatusBL extends BaseBL {
private HrObjectsStatusDAO dao=new HrObjectsStatusDAO();
	public HrObjectsStatusBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
 
	public List<IDBEntity> getDataSet() {
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrObjectsStatusDAO dao = new HrObjectsStatusDAO();
	 
		    List<Hrobjectsstatus> entities =	dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
		} catch (Exception e) {
			
		}
		return null;
	}
private Map<String, Object> convertData( Hrobjectsstatus dataModel){
		/*remark*/
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsStatusEDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HrObjectsStatusEDM.description, dataModel.getDescription());
			
//			map.put(HrObjectsStatusEDM.hRP1000, dataModel.getId().gHRP1000());
		//	map.put(HrObjectsStatusEDM.hRP1001, dataModel.getHRP1001());
			map.put(HrObjectsStatusEDM.statusId, dataModel.getId().getIdHrObjectsStatus());
		
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {
		HrobjectsstatusPK pk = (HrobjectsstatusPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsStatusDAO dao = new HrObjectsStatusDAO();
			Hrobjectsstatus entity =	dao.getByPK(pk);
		      return (IDBEntity) entity;
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

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		Hrobjectsstatus entity=dao.getByPK((HrobjectsstatusPK)primaryKey);
		dao.delete(entity);
		return true;
		
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Hrobjectsstatus entity = (Hrobjectsstatus) data;
//			HrobjectsstatusPK pk= new HrobjectsstatusPK();
//			pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
//			pk.setIdHrObjectsStatus(entity.getId().getIdHrObjectsStatus());
//			
//			entity.setId(pk);
			entity =dao.saveNew(entity);
		return entity;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Hrobjectsstatus founddEntity =dao.getByPK((HrobjectsstatusPK) pk);
			Hrobjectsstatus newEntity= (Hrobjectsstatus) entity;
			founddEntity.setDescription(newEntity.getDescription());
//			founddEntity.setHrp1000s(newEntity.getHrp1000s());
//			founddEntity.setId(newEntity.getId());
//			founddEntity.setTenant(newEntity.getTenant());
			
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
			Hrobjectsstatus idbEntity = (Hrobjectsstatus) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobjectsstatus) entity);
	
	 
}



@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {

	int tenantId = (Integer) edm.get(HrObjectsStatusEDM.tenantId);
	int statusId = (Integer) edm.get(HrObjectsStatusEDM.statusId);
	String description = (String) edm.get(HrObjectsStatusEDM.description);

	
	
	Hrobjectsstatus entity = new Hrobjectsstatus();
//	entity.setTimeConstraint(timeConstraint);
	entity.setDescription(description);
	//entity.setTenant(tenantId);
	
	

	return null;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	PKFactory pkFactory =PKFactory.getInstance();
	int tenantId = (Integer) data.get(HrObjectsStatusEDM.tenantId);
	String description = (String) data.get(HrObjectsStatusEDM.description);
	TenantsDAO tenantDao = new TenantsDAO();
	TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
	tenantPK.setId(tenantId);
	Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
	
	
	
	HrobjectsstatusPK pk = (HrobjectsstatusPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTS);
	pk.setTenants_idTenants(tenantId);
	Hrobjectsstatus entity = new Hrobjectsstatus();
	entity.setId(pk);
	entity.setDescription(description);
	entity.setTenant(tenantEntity);
	Hrobjectsstatus resultEntity =dao.saveNew(entity);
	return convertModelToEDM(resultEntity);
	
	
	
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	try {
		int pkhrObjectStatus =getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
		PKFactory pkFactory=   PKFactory.getInstance();
		
		HrobjectsstatusPK pk =(HrobjectsstatusPK) pkFactory.getPKModel(Constants.PERSISTENCE_HROBJECTS);
		pk.setIdHrObjectsStatus(pkhrObjectStatus);
		pk.setTenants_idTenants(pkTenantId);		 
		String description = (String) data.get(HrObjectsStatusEDM.description);
	 	Hrobjectsstatus entity = dao.getByPK(pk);
		entity.setDescription(description);
		entity =dao.save(entity);
		dao.refresh(entity);
		return convertModelToEDM(entity);
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
}
 
}
