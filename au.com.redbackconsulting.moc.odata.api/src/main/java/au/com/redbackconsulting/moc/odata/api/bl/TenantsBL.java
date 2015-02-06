package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.TenantsEDM;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.Hrrelation;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class TenantsBL extends BaseBL {

	private TenantsDAO dao = new TenantsDAO();

	public TenantsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			TenantsDAO dao = new TenantsDAO();
			List<Tenant> collectin = dao.getAll();
			for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
				Tenant entity = (Tenant) iterator.next();
				Map<String, Object> map = convertData(entity);
				result.add(map);
			}
		} catch (Exception e) {
			int i = 8;
		}
		return result;

	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {

		TenantPK pk = (TenantPK) primaryKeyModel;
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			Tenant entity = dao.getByPK(pk);
			result = convertData(entity);
			return result;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}

		return null;
	}

	private Map<String, Object> convertData(Tenant entity) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(TenantsEDM.tenantId, entity.getTenantPK().getId());
			map.put(TenantsEDM.name, entity.getName());
			map.put(TenantsEDM.tenantCode, entity.getTenantsCode());
			return map;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		TenantPK pk = (TenantPK) primaryKey;

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			TenantsDAO dao = new TenantsDAO();
			Tenant entity = dao.getByPK(pk);
			Collection<Casystem> collection = entity.getCasystems();
			for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
				Casystem caSystems = (Casystem) iterator.next();
				Map<String, Object> map = convertCaSystem(caSystems);
				result.add(map);
			}

			return result;
		} catch (Exception e) {
			int i = 0;
			i = i + 1;
		}
		return null;
	}

	private Map<String, Object> convertCaSystem(Casystem caSystems) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(CaSystemEDM.SYSID, caSystems.getId().getIdsys());
		map.put(CaSystemEDM.SYSDESC, caSystems.getSysdesc());
		map.put(CaSystemEDM.TENANTID, caSystems.getId().getTenants_idTenants());
		return map;
	}

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		Tenant entity = dao.getByPK((TenantPK) primaryKey);
		dao.delete(entity);
		return true;
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Tenant entity = (Tenant) data;
			TenantPK pk = new TenantPK();
			pk.setId(entity.getTenantPK().getId());

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
			Tenant founddEntity = dao.getByPK((TenantPK) pk);
			Tenant newEntity = (Tenant) entity;

			founddEntity.setCasystems(newEntity.getCasystems());
			founddEntity.setHrhiermaps(newEntity.getHrhiermaps());
			founddEntity.setHrhiers(newEntity.getHrhiers());
			founddEntity.setHrobjects(newEntity.getHrobjects());
			founddEntity.setName(newEntity.getName());

			founddEntity = dao.save(founddEntity);

			return founddEntity;
		} catch (Exception e) {
			return entity;
		}
	}

}
