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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrRelationsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrRelationsDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK; 
import au.com.redbackconsulting.moc.persistence.model2.Hrrelation;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HrRelationsBL extends BaseBL {
	private HrRelationsDAO dao = new HrRelationsDAO();

	public HrRelationsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	private Map<String, Object> convertData(Hrrelation dataModel) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// map.put(HrRelationsEDM.tenantId,
			// dataModel.getId().getTenants_idTenants());
			map.put(HrRelationsEDM.relatType, dataModel.getId().getRelatType());
			map.put(HrRelationsEDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HrRelationsEDM.relatTypeT, dataModel.getRelatTypeT());

			return map;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<IDBEntity> getDataSet() {
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrRelationsDAO dao = new HrRelationsDAO();
			List<Hrrelation> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
		} catch (Exception e) {

		}
		return result;
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {

		HrrelationPK pk = (HrrelationPK) primaryKeyModel;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			HrRelationsDAO dao = new HrRelationsDAO();
			Hrrelation entity = dao.getByPK(pk);
		 	return (IDBEntity) entity ;
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

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		Hrrelation entity = dao.getByPK((HrrelationPK) primaryKey);
		dao.delete(entity);
		return true;
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Hrrelation entity = (Hrrelation) data;
			
			
			entity = dao.saveNew(entity);
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Hrrelation founddEntity = dao.getByPK((HrrelationPK) pk);
			Hrrelation newEntity = (Hrrelation) entity;

//			founddEntity.setId(newEntity.getId());
			founddEntity.setRelatTypeT(newEntity.getRelatTypeT());

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
			Hrrelation idbEntity = (Hrrelation) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrrelation) entity);
	
	 
}



@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {


	int tenantId = (Integer) edm.get(HrRelationsEDM.tenantId);
	String relatType = (String) edm.get(HrRelationsEDM.relatType);
	String relatTypeT = (String) edm.get(HrRelationsEDM.relatTypeT);
	
	
	
	Hrrelation entity = new Hrrelation();
entity.setRelatTypeT(relatTypeT);
//entity.setId(id);
	
	
	
	return null;
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	PKFactory pkFactory =PKFactory.getInstance();
	int tenantId = (Integer) data.get(HrRelationsEDM.tenantId);
	String relatType = (String) data.get(HrRelationsEDM.relatType);
	String relatTypeT = (String) data.get(HrRelationsEDM.relatTypeT); 
 
	TenantsDAO tenantDao = new TenantsDAO();
	TenantPK tenantPK = (TenantPK) pkFactory.getPKModel(Constants.PERSISTENCE_TENANTS);
	tenantPK.setId(tenantId);
	Tenant tenantEntity = tenantDao.getByPK(tenantPK);	
	
	
	HrrelationPK pk = (HrrelationPK) pkFactory.getPKModel(Constants.PERSISTENCE_HRRELATIONS);
	pk.setTenants_idTenants(tenantId);
	pk.setRelatType(relatType);
	
	Hrrelation entity = new Hrrelation();
	entity.setId(pk);
	entity.setRelatTypeT(relatTypeT);
	
	
	 	Hrrelation resultEntity =dao.saveNew(entity);
	return convertModelToEDM(resultEntity);
	
	
	
}

@Override
public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
		Map<String, Object> data) {
	PKFactory pkFactory =PKFactory.getInstance();
	
	try {
		String pkRelatType =getKeyValueString(uriInfo.getKeyPredicates().get(0));
		int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
		 
		HrrelationPK pk =  (HrrelationPK) pkFactory.getPKModel(Constants.PERSISTENCE_HRRELATIONS);
		pk.setRelatType(pkRelatType);
		pk.setTenants_idTenants(pkTenantId);
		
		
	//	String relatType = (String) data.get(HrRelationsEDM.relatType);
		String relatTypeT = (String) data.get(HrRelationsEDM.relatTypeT);
	 
		 
		Hrrelation  entity = dao.getByPK(pk);
		entity.setRelatTypeT(relatTypeT);
		 
		entity =dao.save(entity);
		dao.refresh(entity);
		return convertModelToEDM(entity);
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
}

}
