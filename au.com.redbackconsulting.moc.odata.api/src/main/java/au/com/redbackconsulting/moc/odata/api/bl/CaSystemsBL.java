package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_CASYSTEMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.entry.ODataEntry;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.UriInfo;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
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

public class CaSystemsBL extends BaseBL {

	private CaSystemsDAO dao = new CaSystemsDAO();

	public CaSystemsBL(BLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	private  List<IDBEntity> getDataSet() {
		// TODO Auto-generated method stub

		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			CaSystemsDAO dao = new CaSystemsDAO();
			List<Casystem> entities = dao.getAll();
			List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
			idbEntities.addAll(entities);
			return idbEntities;
			 
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

	private  List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {

		return null;
	}

	private  boolean deleteData(IPkModel primaryKey) {

		Casystem entity = dao.getByPK((CasystemPK) primaryKey);
		dao.delete(entity);
		return true;
	}

	private  IDBEntity createData(IDBEntity data) {
		try {
			Casystem entity = (Casystem) data;

			entity = dao.saveNew(entity);
			return entity;
		} catch (Exception e) {
			return null;
		}

	}

	private  IDBEntity updateData(IPkModel pk, IDBEntity entity) {
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

	private  Map<String, Object> convertModelToEDM(IDBEntity entity) {

		return convertData((Casystem) entity);

	}

	private List<Map<String, Object>> convertModelToEDMCollection(
			List<IDBEntity> entities) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
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

	private  IDBEntity convertEDMDataToModelEDM(Map<String, Object> edm) {
		Casystem entity=new Casystem();
		
		String SYSDESC = (String) edm.get(CaSystemEDM.SYSDESC);
		Integer SYSID = (Integer) edm.get(CaSystemEDM.SYSID);
		
		Integer tenantid = (Integer) edm.get(CaSystemEDM.TENANTID);
		
		CasystemPK pk = (CasystemPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_CASYSTEMS);
		pk.setIdsys(SYSID);
		pk.setTenants_idTenants(tenantid);
		
		entity.setId(pk);
		entity.setSysdesc(SYSDESC);
		//entity.setTenant(tenant);
		
return entity;

}

	@Override
	public Map<String, Object> createNew(Map<String, Object> data) {
		try {
			int tenantId = (Integer) data.get(CaSystemEDM.TENANTID);
			String sysDesc = (String) data.get(CaSystemEDM.SYSDESC);
			CasystemPK pk = new CasystemPK();
			pk.setTenants_idTenants(tenantId);
			Casystem entity = new Casystem();
			entity.setId(pk);
			entity.setSysdesc(sysDesc);
			 entity =(Casystem) createData(entity);
			 return convertModelToEDM(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean delete(DeleteUriInfo uriInfo) {
		try {
			int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));

			 
			CasystemPK pk =  (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
			pk.setIdsys(sysId);
			pk.setTenants_idTenants((tenantId));
			boolean status =  deleteData(pk);
			return status;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Map<String, Object> update(PutMergePatchUriInfo uriInfo,
			Map<String, Object> data) {
		try {
		 
			CasystemPK pk = (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
			int pksysId =getKeyValue(uriInfo.getKeyPredicates().get(0));
			int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
			
			pk.setIdsys(pksysId);
			pk.setTenants_idTenants(pkTenantId);

			Casystem entity = (Casystem)  convertEDMDataToModelEDM(data);
			
			entity = (Casystem) updateData(pk, entity);
			return convertModelToEDM(entity);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Map<String, Object> read(GetEntityUriInfo uriInfo) {
		try {
			int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
			int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));

			 
			CasystemPK pk = (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
			pk.setIdsys(sysId);
			pk.setTenants_idTenants((tenantId));

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
		List<IDBEntity> entities = getDataSet();
		List<Map<String, Object>> data = convertModelToEDMCollection(entities);
		return data;
	}
}
