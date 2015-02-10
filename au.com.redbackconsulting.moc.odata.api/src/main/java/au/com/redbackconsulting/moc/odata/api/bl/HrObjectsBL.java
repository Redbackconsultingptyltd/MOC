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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.HRP1000DAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

 
public class HrObjectsBL extends BaseBL {
private HrObjectsDAO dao=new HrObjectsDAO();
	public HrObjectsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
 
	public List<IDBEntity> getDataSet() {
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
			result = convertData(entity);
			return (IDBEntity) result;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

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
			Hrobject idbEntity = (Hrobject) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobject) entity);
	
	 
}



@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
	// TODO Auto-generated method stub
	return null;
}
 
}
