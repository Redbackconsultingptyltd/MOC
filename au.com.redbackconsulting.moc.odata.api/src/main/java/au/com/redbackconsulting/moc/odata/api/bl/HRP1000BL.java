package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIER;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HRP1000EDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.persistence.HRP1000DAO;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsstatus;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HRP1000BL extends BaseBL {
	private HRP1000DAO dao = new HRP1000DAO();
	private String dateformat = "dd-MM-yyyy";

	public HRP1000BL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

 
	private List<IDBEntity> getDataSet() {

		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			 

			List<Hrp1000> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
		} catch (Exception e) {

		}
		return null;
	}

 
	private IDBEntity getData(IPkModel primaryKeyModel) {

		Hrp1000PK pk = (Hrp1000PK) primaryKeyModel;
		 
		try {
	 
			Hrp1000 entity = dao.getByPK(pk);
			 			return (IDBEntity) entity ;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

		return null;
	}

 
	private List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> convertData(Hrp1000 dataModel) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
 			map.put(HRP1000EDM.changedBy, dataModel.getChangedBy());
 			Date changedOn =dataModel.getChangedOn();
 			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
 			
 			String chagedOnString = simpleDateFormat.format(changedOn);
 			map.put(HRP1000EDM.changedOn, chagedOnString);
			map.put(HRP1000EDM.guid, dataModel.getGuid());
			
			String validfromString = simpleDateFormat.format(dataModel.getId().getValidFrom());
			map.put(HRP1000EDM.validFrom, validfromString);
			
			String validToString =simpleDateFormat.format(dataModel.getId().getValidTo());
			map.put(HRP1000EDM.validTo, validToString);
			map.put(HRP1000EDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HRP1000EDM.objectId, dataModel.getId().getIdobjectId());
			map.put(HRP1000EDM.objectType, dataModel.getId().getIdobjectType());
			
			map.put(HRP1000EDM.status, dataModel.getHrobjectsstatus().getId().getIdHrObjectsStatus());
					
			map.put(HRP1000EDM.objectDesc, dataModel.getObjectDesc());
			map.put(HRP1000EDM.seqNr, dataModel.getSeqNo());
			map.put(HRP1000EDM.stext, dataModel.getStext());
			return map;

		} catch (Exception e) {
			return null;
		}
	}

 
	private boolean deleteData(IPkModel primaryKey) {
		Hrp1000 entity = dao.getByPK((Hrp1000PK) primaryKey);
		dao.delete(entity);
		return true;
	}

	 
	private IDBEntity createData(IDBEntity data) {
		try {
			Hrp1000 entity = (Hrp1000) data;
			 
			entity = dao.saveNew(entity);
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
 
	private IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Hrp1000 founddEntity = dao.getByPK((Hrp1000PK) pk);
			Hrp1000 newEntity = (Hrp1000) entity;
			founddEntity.setChangedBy(newEntity.getChangedBy());
			founddEntity.setChangedOn(newEntity.getChangedOn());
			founddEntity.setId(newEntity.getId());
			founddEntity.setGuid(newEntity.getGuid());
			founddEntity.setHrobject(newEntity.getHrobject());
			founddEntity.setHrobjectsstatus(newEntity.getHrobjectsstatus());
			founddEntity.setObjectDesc(newEntity.getObjectDesc());
			founddEntity.setSeqNo(newEntity.getSeqNo());
			founddEntity.setStext(newEntity.getStext());

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
	
	private Date getKeyValueDate(KeyPredicate key ) throws ODataException {
		EdmProperty property = key.getProperty();
		EdmSimpleType type = (EdmSimpleType) property.getType();
		 
		return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
				property.getFacets(), Date.class);
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
	


private List<Map<String, Object>> convertModelToEDMCollection(
		List<IDBEntity> entities) {
	 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	try {
		 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			Hrp1000 idbEntity = (Hrp1000) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

private Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrp1000) entity);
	
	 
}



 
private IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
try {
	

	int tenantId = (Integer) edm.get(HRP1000EDM.tenantId);
 	String changedBy = (String) edm.get(HRP1000EDM.changedBy);
 	String changedOn = (String) edm.get(HRP1000EDM.changedOn);
	String guid = (String) edm.get(HRP1000EDM.guid);
 	String objectDesc = (String) edm.get(HRP1000EDM.objectDesc);
	int objectId = (Integer) edm.get(HRP1000EDM.objectId);
	int objectType = (Integer) edm.get(HRP1000EDM.objectType);
	Integer seqNr = (Integer) edm.get(HRP1000EDM.seqNr);
	int status = (Integer) edm.get(HRP1000EDM.status);
	String stext = (String) edm.get(HRP1000EDM.stext);
 	String validFrom = (String) edm.get(HRP1000EDM.validFrom);
 	String validTo = (String) edm.get(HRP1000EDM.validTo);
 	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
		
 	Date validFromDate = simpleDateFormat.parse(validFrom);
 	Date validToDate = simpleDateFormat.parse(validTo);
 	Date changedOnDate = simpleDateFormat.parse(changedOn);
	
 	Hrp1000PK pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1000);
	pk.setIdobjectId(objectId);
	pk.setIdobjectType(objectType);
//	pk.setStatus(status);
	pk.setTenants_idTenants(tenantId);
	pk.setValidFrom(validFromDate);
	pk.setValidTo(validToDate);
	
	Hrp1000 entity = new Hrp1000();
	entity.setId(pk);
	entity.setChangedBy(changedBy);
	entity.setChangedOn(changedOnDate);
	entity.setGuid(guid);
	entity.setObjectDesc(objectDesc);
	entity.setSeqNo(seqNr);
	entity.setStext(stext);

	return entity;

} catch (Exception e) {
	return null;
}
	 
	
}

@Override
public Map<String, Object> createNew(Map<String, Object> data) {
	try {
	 
		Hrp1000 entity = (Hrp1000)  convertEDMDataToModelEDM(data);
		entity =(Hrp1000) createData(entity);
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
		int pkObjectId  = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkObjectType  = getKeyValue(uriInfo.getKeyPredicates().get(1));
		String pkValidToString = getKeyValueString(uriInfo.getKeyPredicates().get(2));
		String pkValidFromString = getKeyValueString(uriInfo.getKeyPredicates().get(3));
	//	int pkStatus = getKeyValue(uriInfo.getKeyPredicates().get(4));
		int pkTenantId = getKeyValue(uriInfo.getKeyPredicates().get(4));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
		Date pkValidFrom =dateFormat.parse(pkValidFromString);
		Date pkValidTo = dateFormat.parse(pkValidToString);
		
		
		Hrp1000PK pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1000);
		pk.setIdobjectId(pkObjectId); 
		pk.setIdobjectType(pkObjectType);
//		pk.setStatus(pkStatus);
		pk.setValidFrom(pkValidFrom);
		pk.setValidTo(pkValidTo);
		pk.setTenants_idTenants(pkTenantId);
		
		
//		int tenantId = (Integer) data.get(HRP1000EDM.tenantId);
	 	String changedBy = (String) data.get(HRP1000EDM.changedBy);
	 	String changedOn = (String) data.get(HRP1000EDM.changedOn);
		String guid = (String) data.get(HRP1000EDM.guid);
	 	String objectDesc = (String) data.get(HRP1000EDM.objectDesc);
//		int objectId = (Integer) data.get(HRP1000EDM.objectId);
//		int objectType = (Integer) data.get(HRP1000EDM.objectType);
		Integer seqNr = (Integer) data.get(HRP1000EDM.seqNr);
//		int status = (Integer) data.get(HRP1000EDM.status);
		String stext = (String) data.get(HRP1000EDM.stext);
//	 	String validFrom = (String) data.get(HRP1000EDM.validFrom);
//	 	String validTo = (String) data.get(HRP1000EDM.validTo);
	 	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
			
//	 	Date validFromDate = simpleDateFormat.parse(validFrom);
//	 	Date validToDate = simpleDateFormat.parse(validTo);
	 	Date changedOnDate = simpleDateFormat.parse(changedOn);
		
	 	
	 	
	 	Hrp1000 entity = dao.getByPK(pk);
//		entity.setId(pk);
		entity.setChangedBy(changedBy);
		entity.setChangedOn(changedOnDate);
		entity.setGuid(guid);
		entity.setObjectDesc(objectDesc);
		entity.setSeqNo(seqNr);
		entity.setStext(stext);
		entity = dao.save(entity);
		return convertData(entity);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

@Override
public Map<String, Object> read(GetEntityUriInfo uriInfo) {
	try {
		int objectId  = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int objectType  = getKeyValue(uriInfo.getKeyPredicates().get(1));
		String validToString = getKeyValueString(uriInfo.getKeyPredicates().get(2));
		String validFromString = getKeyValueString(uriInfo.getKeyPredicates().get(3));
		//int status = getKeyValue(uriInfo.getKeyPredicates().get(4));
		int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(4));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
		Date validFrom =dateFormat.parse(validFromString);
		Date validTo = dateFormat.parse(validToString);
		
		
		Hrp1000PK pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1000);
		pk.setIdobjectId(objectId); 
		pk.setIdobjectType(objectType);
//		pk.setStatus(status);
		pk.setValidFrom(validFrom);
		pk.setValidTo(validTo);
		pk.setTenants_idTenants(tenantId);
		IDBEntity entity =  getData(pk);
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
		int pkObjectId  = getKeyValue(uriInfo.getKeyPredicates().get(0));
		int pkObjectType  = getKeyValue(uriInfo.getKeyPredicates().get(1));
		String pkValidToString = getKeyValueString(uriInfo.getKeyPredicates().get(2));
		String pkValidFromString = getKeyValueString(uriInfo.getKeyPredicates().get(3));
//		int pkStatus = getKeyValue(uriInfo.getKeyPredicates().get(4));
		int pkTenantId = getKeyValue(uriInfo.getKeyPredicates().get(4));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
		Date pkValidFrom =dateFormat.parse(pkValidFromString);
		Date pkValidTo = dateFormat.parse(pkValidToString);
		
		
		Hrp1000PK pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1000);
		pk.setIdobjectId(pkObjectId); 
		pk.setIdobjectType(pkObjectType);
//		pk.setStatus(pkStatus);
		pk.setValidFrom(pkValidFrom);
		pk.setValidTo(pkValidTo);
		pk.setTenants_idTenants(pkTenantId);
	 
	 	
	 	Hrp1000 entity = dao.getByPK(pk);
	 	dao.delete(entity);
//		entity.setId(pk);
		 
		return true;
	} catch (Exception e) {
		return false;
	}
}
 
}
