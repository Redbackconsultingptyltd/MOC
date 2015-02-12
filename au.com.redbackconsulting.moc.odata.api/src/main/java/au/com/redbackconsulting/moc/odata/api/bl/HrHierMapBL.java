package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIERMAP;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.UriInfo;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;
import org.eclipse.persistence.internal.jpa.jpql.HermesParser;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
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
	public HrHierMapBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	private  List<IDBEntity> getDataSet() {
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

	private  IDBEntity getData(IPkModel primaryKeyModel) {
 
		HrhiermapPK pk = (HrhiermapPK) primaryKeyModel;
		try {
			HrHierMapDAO dao = new HrHierMapDAO();
			Hrhiermap entity =	dao.getByPK(pk);
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

private  boolean deleteData(IPkModel primaryKey) {
	// TODO Auto-generated method stub
	Hrhiermap entity = dao.getByPK((HrhiermapPK) primaryKey);
	dao.delete(entity);
	
	return true;
}

private  IDBEntity createData(IDBEntity data) {
	try {
		
		Hrhiermap entity=(Hrhiermap) data;	
		 	HrHierDAO hrHierDao = new HrHierDAO();
	 	 
		 
			entity =dao.saveNew(entity);
		 
	return entity;
	} catch (Exception e) {
		return null;
	}

}

private  IDBEntity updateData(IPkModel pk, IDBEntity entity) {

try {
	
	Hrhiermap founddEntity =dao.getByPK((HrhiermapPK) pk);
	Hrhiermap newEntity= (Hrhiermap) entity;
	//founddEntity.setHrhier(newEntity.getHrhier());          
	founddEntity.setObjectTypeId(newEntity.getObjectTypeId());  
//	founddEntity.setTenant(newEntity.getTenant());
//	founddEntity.setId(newEntity.getId());
	founddEntity.setRelatType(newEntity.getRelatType());
	founddEntity.setSkip(newEntity.getSkip());
//	founddEntity.setSObjectTypeId(newEntity.getSObjectTypeId());
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




private  List<Map<String, Object>> convertModelToEDMCollection(
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

private  Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrhiermap) entity);
	
	 
}

private  IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {


	int tenantId = (Integer) edm.get(HrHierMapEDM.tenantId);
	int hierId = (Integer) edm.get(HrHierMapEDM.hierId);
	String objectType = (String) edm.get(HrHierMapEDM.objectType);
	String relatType = (String) edm.get(HrHierMapEDM.relatType);
	int seqNo = (Integer) edm.get(HrHierMapEDM.seqNo);
	String skip = (String) edm.get(HrHierMapEDM.skip);
	String sObjType = (String) edm.get(HrHierMapEDM.sObjType);



	
	Hrhiermap entity = new Hrhiermap();
	HrhiermapPK pk = (HrhiermapPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRHIERMAP);
	pk.setHrHierId(hierId);
	pk.setSeqNo(seqNo);
	pk.setTenants_idTenants(tenantId);
	
	
	
	entity.setId(pk);
	entity.setSkip(skip);
	entity.setRelatType(relatType);


	
	return entity;

}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	try {
//		int tenantId = (Integer) data.get(HrHierMapEDM.tenantId);
//		int hierId = (Integer) data.get(HrHierMapEDM.hierId);
//		String objectType = (String) data.get(HrHierMapEDM.objectType);
//		int relatType = (Integer) data.get(HrHierMapEDM.relatType);

//		HrhiermapPK pk = (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);
//		pk.setTenants_idTenants(tenantId);

		Hrhiermap entity = (Hrhiermap)  convertEDMDataToModelEDM(data);

//		entity.setId(pk);
		// entity.setHierdesc(hierDesc);
		entity = (Hrhiermap) createData(entity);
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
		int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));

		int seqNo =getKeyValue(uriInfo.getKeyPredicates().get(1));
		int pktenantId =getKeyValue(uriInfo.getKeyPredicates().get(2));
		PKFactory pkFactory= PKFactory.getInstance();
		HrhiermapPK pk = (HrhiermapPK) pkFactory.getPKModel(PERSISTENCE_HRHIERMAP);
		pk.setTenants_idTenants(pktenantId);
		pk.setHrHierId(pkId);
		pk.setSeqNo(seqNo);
		
		//Read Form Data
		Hrhiermap entity =   (Hrhiermap) convertEDMDataToModelEDM(data);
	
		
		entity =  (Hrhiermap)  updateData(pk, entity);
		return convertModelToEDM(entity);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

@Override
public Map<String, Object> read(GetEntityUriInfo uriInfo) {
	try {
	 
		
		int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
		int seqNo = getKeyValue(uriInfo.getKeyPredicates().get(2));

		HrhiermapPK pk = (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);

		pk.setHrHierId((id));
		pk.setTenants_idTenants(tenantId);
		pk.setSeqNo(seqNo);

		// Map<String, Object> data = blModel.getData(pk);
		IDBEntity entity =  getData(pk);
		Map<String, Object> data = convertModelToEDM(entity);

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
		int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
		int seqNo = getKeyValue(uriInfo.getKeyPredicates().get(2));

	 
		HrhiermapPK pk =  (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);

		pk.setHrHierId((id));
		pk.setTenants_idTenants(tenantId);
		pk.setSeqNo(seqNo);

		boolean status =  deleteData(pk);
		return status;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}
 
}
