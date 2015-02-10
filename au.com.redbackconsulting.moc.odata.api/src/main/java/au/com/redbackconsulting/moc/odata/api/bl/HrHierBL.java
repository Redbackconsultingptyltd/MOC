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
	private HrHierDAO dao = new HrHierDAO();
	public HrHierBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub
		
		List<IDBEntity> result = new ArrayList<IDBEntity>();
 
			HrHierDAO dao = new HrHierDAO();
		List<Hrhier> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		
	
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {
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

	
 

	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
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

@Override
public boolean deleteData(IPkModel primaryKey) {

	Hrhier entity = dao.getByPK((HrhierPK) primaryKey);
	dao.delete(entity);
	return true;
}

@Override
public IDBEntity createData(IDBEntity data) {
	try {
		Hrhier entity = (Hrhier) data;
	
	
	
			entity =dao.saveNew(entity);
	return entity;
	} catch (Exception e) {
		return null;
	}
	
}
@Override
public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
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

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrhier) entity);
	
	 
}

public List<Map<String, Object>>  convertModelToEDMCollection(List<IDBEntity> entities){
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


@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {


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



}
