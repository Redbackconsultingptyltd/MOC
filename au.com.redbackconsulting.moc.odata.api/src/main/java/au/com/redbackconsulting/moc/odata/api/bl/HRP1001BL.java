package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_CASYSTEMS;

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
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.odata.api.edmconstants.HRP1001EDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HRP1001DAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1001;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1001PK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HRP1001BL extends BaseBL {

	private HRP1001DAO dao;
	public HRP1001BL(BLModelFactory bmf) {
		super(bmf);
		dao= new HRP1001DAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> createNew(Map<String, Object> data) {
		try {
			String format = "dd-MM-yyyy";
			PKFactory pkfactory =PKFactory.getInstance();

			String changedBy= (String) data.get(HRP1001EDM.changedBy);
			String changedOnString = (String) data.get(HRP1001EDM.changedOn);
			String guid = (String) data.get(HRP1001EDM.guid);
			int objectId = (Integer) data.get(HRP1001EDM.objectId);
			int objectType = (Integer) data.get(HRP1001EDM.objectType);
			String relatType = (String) data.get(HRP1001EDM.relatType);
			int robjectId = (Integer) data.get(HRP1001EDM.rsobjectId);
			int robjectType = (Integer) data.get(HRP1001EDM.rsobjectType);
			String status = (String) data.get(HRP1001EDM.status);
			String subType = (String) data.get(HRP1001EDM.subType);
			int tenantId = (Integer) data.get(HRP1001EDM.tenantId);
			String validFromString = (String) data.get(HRP1001EDM.validFrom);
			String validToString = (String) data.get(HRP1001EDM.validTo);
			
			Date validFrom = convertStringToDate(validFromString, format);
			Date validTo = convertStringToDate(validToString, format);
			Date changedOn = convertStringToDate(changedOnString, format);
			
			
			
			
			 
			 
		
						Hrp1001PK pk = (Hrp1001PK)pkfactory.getPKModel(Constants.PERSISTENCE_HRP1001);
			pk.setIdobjectId(objectId);
			pk.setIdobjectType(objectType);
			pk.setRelatType(relatType );
			pk.setTenants_idTenants(tenantId);
			pk.setValidFrom(validFrom);
			pk.setValidTo(validTo);
			
			 
			 
			Hrp1001 entity = new Hrp1001();
			entity.setId(pk);
			entity.setChangedBy(changedBy);
			entity.setChangedOn(changedOn);
			entity.setGuid(guid);
			entity.setIdsobjectId(robjectId);
			entity.setIdsobjectType(robjectType);
			entity.setStatus(status);
			entity.setSubType(subType);

			Hrp1001 resultEntity =dao.saveNew(entity);
			return convertModelToEDM(resultEntity);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
			Map<String, Object> data) {
		try {
			String format = "dd-MM-yyyy";
			int pkObjectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int pkObjectId = getKeyValue(uriInfo.getKeyPredicates().get(1));
			String pkrelatType = getKeyValueString(uriInfo.getKeyPredicates().get(2));
			String pkValidFrom = getKeyValueString(uriInfo.getKeyPredicates().get(3));
			String pkValidTo = getKeyValueString(uriInfo.getKeyPredicates().get(4));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(5));

			 
			Hrp1001PK pk = (Hrp1001PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1001);
			pk.setIdobjectId(pkObjectId);
			pk.setIdobjectType(pkObjectType);
			pk.setRelatType(pkrelatType);
			pk.setValidFrom(convertStringToDate(pkValidFrom, format));
			pk.setValidTo(convertStringToDate(pkValidTo, format));
			pk.setTenants_idTenants((tenantId));

			
			Hrp1001 entity =  dao.getByPK(pk);
			
			
			String changedBy= (String) data.get(HRP1001EDM.changedBy);
			String changedOnString = (String) data.get(HRP1001EDM.changedOn);
			String guid = (String) data.get(HRP1001EDM.guid);
//			int objectId = (Integer) data.get(HRP1001EDM.objectId);
//			int objectType = (Integer) data.get(HRP1001EDM.objectType);
//			String relatType = (String) data.get(HRP1001EDM.relatType);
			int robjectId = (Integer) data.get(HRP1001EDM.rsobjectId);
			int robjectType = (Integer) data.get(HRP1001EDM.rsobjectType);
			String status = (String) data.get(HRP1001EDM.status);
			String subType = (String) data.get(HRP1001EDM.subType);
//			int tenantId = (Integer) data.get(HRP1001EDM.tenantId);
//			String validFromString = (String) data.get(HRP1001EDM.validFrom);
//			String validToString = (String) data.get(HRP1001EDM.validTo);
			
//			Date validFrom = convertStringToDate(validFromString, format);
//			Date validTo = convertStringToDate(validToString, format);
			Date changedOn = convertStringToDate(changedOnString, format);
			 
			 
			entity.setChangedBy(changedBy);
			entity.setChangedOn(changedOn);
			entity.setGuid(guid);
			entity.setIdsobjectId(robjectId);
			entity.setIdsobjectType(robjectType);
			entity.setStatus(status);
			entity.setSubType(subType);
			entity =dao.save(entity);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return null;
	}

	@Override
	public Map<String, Object> read(GetEntityUriInfo uriInfo) {
		try {
			String format = "dd-MM-yyyy";
			int pkObjectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int pkObjectId = getKeyValue(uriInfo.getKeyPredicates().get(1));
			String pkrelatType = getKeyValueString(uriInfo.getKeyPredicates().get(2));
			String pkValidFrom = getKeyValueString(uriInfo.getKeyPredicates().get(3));
			String pkValidTo = getKeyValueString(uriInfo.getKeyPredicates().get(4));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(5));

			 
			Hrp1001PK pk = (Hrp1001PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1001);
			pk.setIdobjectId(pkObjectId);
			pk.setIdobjectType(pkObjectType);
			pk.setRelatType(pkrelatType);
			pk.setValidFrom(convertStringToDate(pkValidFrom, format));
			pk.setValidTo(convertStringToDate(pkValidTo, format));
			pk.setTenants_idTenants((tenantId));

			
			Hrp1001 entity =  dao.getByPK(pk);
			
			Map<String, Object> data =  convertModelToEDM(entity);
			return data;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null; 
	}

	@Override
	public boolean delete(DeleteUriInfo uriInfo) {
		try {
			String format = "dd-MM-yyyy";
			int pkObjectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int pkObjectId = getKeyValue(uriInfo.getKeyPredicates().get(1));
			String pkrelatType = getKeyValueString(uriInfo.getKeyPredicates().get(2));
			String pkValidFrom = getKeyValueString(uriInfo.getKeyPredicates().get(3));
			String pkValidTo = getKeyValueString(uriInfo.getKeyPredicates().get(4));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(5));

			 
			Hrp1001PK pk = (Hrp1001PK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRP1001);
			pk.setIdobjectId(pkObjectId);
			pk.setIdobjectType(pkObjectType);
			pk.setRelatType(pkrelatType);
			pk.setValidFrom(convertStringToDate(pkValidFrom, format));
			pk.setValidTo(convertStringToDate(pkValidTo, format));
			pk.setTenants_idTenants((tenantId));

			
			Hrp1001 entity =  dao.getByPK(pk);
			dao.delete(entity);
			return true;
		}catch(Exception e){
		return false;	
		}
	}

	@Override
	public List<Map<String, Object>> readSet() {
		try {
	
		List<IDBEntity> resultSet = getDataSet();
		List<Map<String, Object>> data = convertModelToEDMCollection(resultSet);

			return data;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	private  List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub

		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			 
			List<Hrp1001> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
			 
		} catch (Exception e) {

		}
		return result;

	}
		
	 

	private   List<Map<String, Object>> convertModelToEDMCollection(
			List<IDBEntity> entities) {
		 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		try {
			 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
				Hrp1001 idbEntity = (Hrp1001) iterator.next();
				result.add(convertModelToEDM(idbEntity));
			}
			return result;
		} catch (Exception e) {
			return result;
		}
		
	}
	
	
	
	private Map<String, Object>  convertModelToEDM(Hrp1001 dataModel){

		try {
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HRP1001EDM.objectType, dataModel.getId().getIdobjectType());
			map.put(HRP1001EDM.objectId, dataModel.getId().getIdobjectId());
			map.put(HRP1001EDM.relatType, dataModel.getId().getRelatType());
			
			Date validFrom = dataModel.getId().getValidFrom();
			Date validTo = dataModel.getId().getValidTo();
			Date changedOn = dataModel.getChangedOn();
			String format = "dd-MM-yyyy";
			map.put(HRP1001EDM.validFrom, convertDateToString(validFrom, format));
			map.put(HRP1001EDM.validTo, convertDateToString(validTo, format));
			map.put(HRP1001EDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HRP1001EDM.subType, dataModel.getSubType());
			map.put(HRP1001EDM.rsobjectType, dataModel.getIdsobjectType());
			map.put(HRP1001EDM.rsobjectId, dataModel.getIdsobjectId());
			map.put(HRP1001EDM.status, dataModel.getStatus());
			map.put(HRP1001EDM.changedBy, dataModel.getChangedBy());
			map.put(HRP1001EDM.changedOn, convertDateToString(changedOn, format));
			map.put(HRP1001EDM.guid, dataModel.getGuid());
			
			
			
			
			
			 
			return map;
			
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


}
