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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HRP1000EDM;
import au.com.redbackconsulting.moc.persistence.HRP1000DAO;
import au.com.redbackconsulting.moc.persistence.HrObjectRelDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsstatus;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HRP1000BL extends BaseBL {
	private HRP1000DAO dao = new HRP1000DAO();

	public HRP1000BL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IDBEntity> getDataSet() {

		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HRP1000DAO dao = new HRP1000DAO();

			List<Hrp1000> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {

		Hrp1000PK pk = (Hrp1000PK) primaryKeyModel;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
	 
			Hrp1000 entity = dao.getByPK(pk);
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

	private Map<String, Object> convertData(Hrp1000 dataModel) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HRP1000EDM.changedBy, dataModel.getChangedBy());
			map.put(HRP1000EDM.changedOn, dataModel.getChangedOn());
			map.put(HRP1000EDM.guid, dataModel.getGuid());
			 map.put(HRP1000EDM.tenantId, dataModel.getId().getTenants_idTenants());
			map.put(HRP1000EDM.hrObjectsStatus, dataModel.getHrobjectsstatus());
			map.put(HRP1000EDM.objectDesc, dataModel.getObjectDesc());
			map.put(HRP1000EDM.objectId, dataModel.getId().getIdobjectId());
			map.put(HRP1000EDM.objectType, dataModel.getId().getIdobjectType());
			map.put(HRP1000EDM.seqNr, dataModel.getSeqNo());
			map.put(HRP1000EDM.status, dataModel.getId().getStatus());
			map.put(HRP1000EDM.stext, dataModel.getStext());
			map.put(HRP1000EDM.validFrom, dataModel.getId().getValidFrom());
			map.put(HRP1000EDM.validTo, dataModel.getId().getValidTo());
			return map;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		Hrp1000 entity = dao.getByPK((Hrp1000PK) primaryKey);
		dao.delete(entity);
		return true;
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Hrp1000 entity = (Hrp1000) data;
			Hrp1000PK pk = new Hrp1000PK();
			pk.setTenants_idTenants(entity.getId().getTenants_idTenants());
			pk.setValidFrom(entity.getId().getValidFrom());
			pk.setValidTo(entity.getId().getValidTo());
			pk.setStatus(entity.getId().getStatus());
			pk.setIdobjectType(entity.getId().getIdobjectType());
			pk.setIdobjectId(entity.getId().getIdobjectId());

			entity.setId(pk);
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
			Hrp1000 idbEntity = (Hrp1000) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrp1000) entity);
	
	 
}



@Override
public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
	// TODO Auto-generated method stub
	return null;
}
 
}
