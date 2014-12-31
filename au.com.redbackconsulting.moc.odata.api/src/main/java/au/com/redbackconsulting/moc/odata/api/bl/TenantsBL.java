package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.TenantsEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.TenantsDAO;
import au.com.redbackconsulting.moc.persistence.model.CaSystems;
import au.com.redbackconsulting.moc.persistence.model.CaSystemsPk;
import au.com.redbackconsulting.moc.persistence.model.IPkModel;
import au.com.redbackconsulting.moc.persistence.model.ITenantsPK;
import au.com.redbackconsulting.moc.persistence.model.Tenants;
import au.com.redbackconsulting.moc.persistence.model.TenantsPk;

public class TenantsBL extends BaseBL {

	public TenantsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			TenantsDAO dao = new TenantsDAO();
		List<Tenants> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Tenants entity = (Tenants) iterator.next();
			Map<String, Object> map = convertData(entity);
		result.add(map);
		}
		} catch (Exception e) {
			
		}
		return result;
		
		
	}

	
	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
	
		
		
		TenantsPk pk = (TenantsPk) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			TenantsDAO dao = new TenantsDAO();
		Tenants entity =	dao.getByPK(pk);
		result= convertData(entity);
		return result;
		} catch (Exception e) {
			int i =0;
			i=i+1;
		}
		
		
		
		return null;
	}

	@Override
	public boolean deleteData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> updateData(Map<String, Object> valueMap,
			Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> createData(Map<String, Object> valueMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Map<String, Object> convertData(Tenants entity) {
		 	
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put(TenantsEDM.tenantId, entity.getTenantId());
				map.put(TenantsEDM.name, entity.getName());
				map.put(TenantsEDM.tenantCode, entity.getTenantCode());
				return map;
				
			} catch (Exception e) {
				return null;
			}
		}
		
	}


 
