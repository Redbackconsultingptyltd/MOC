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

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.HrHierDAO;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class CaSystemsBL extends BaseBL {

	private CaSystemsDAO dao = new CaSystemsDAO();

	public CaSystemsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub
		
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			CaSystemsDAO dao = new CaSystemsDAO();
		List<Casystem> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
//		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
//			Casystem casystem = (Casystem) iterator.next();
//			Map<String, Object> map = convertData(casystem);
//		result.add((IDBEntity) map);
//		}
		} catch (Exception e) {
			
		}
		return result;
		
	
	}

	

	

	public IDBEntity getData(IPkModel primaryKeyModel) {
		CasystemPK pk = (CasystemPK) primaryKeyModel;
		
		try {

			Casystem entity = dao.getByPK(pk);
		
			return (IDBEntity) entity;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

		return null;
	}

	private Map<String, Object> convertData(Casystem dataModel) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put(CaSystemEDM.SYSID, dataModel.getId().getIdsys());
			map.put(CaSystemEDM.SYSDESC, dataModel.getSysdesc());
			map.put(CaSystemEDM.TENANTID, dataModel.getId()
					.getTenants_idTenants());
			return map;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {

		return null;
	}

	
	@Override
	public boolean deleteData(IPkModel primaryKey) {

		Casystem entity = dao.getByPK((CasystemPK) primaryKey);
		dao.delete(entity);
		return true;
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Casystem entity = (Casystem) data;
			 
			 
			entity = dao.saveNew(entity);
			return entity;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Casystem founddEntity = dao.getByPK((CasystemPK) pk);
			Casystem newEntity = (Casystem) entity;
			founddEntity.setSysdesc(newEntity.getSysdesc());
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

		return convertData((Casystem) entity);
		
		 
	}

	public List<Map<String, Object>>  convertModelToEDMCollection(List<IDBEntity> entities){
		 List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		try {
			 for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
				Casystem idbEntity = (Casystem) iterator.next();
				result.add(convertData(idbEntity));
			}
			return result;
		} catch (Exception e) {
			return result;
		}
		
		 
	}





	@Override
	public IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
		// TODO Auto-generated method stub
		return null;
	}


	



}
