package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.persistence.CaSystemsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
public class CaSystemsBL extends BaseBL   {

	private CaSystemsDAO dao = new CaSystemsDAO();
 
	public CaSystemsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}


 
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		CasystemPK pk = (CasystemPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
	 
		Casystem entity =	dao.getByPK(pk);
		result= convertData(entity);
		return result;
		} catch (Exception e) {
			int i =0;
			i=i+1;
		}
		
		
		
		return null;
	}

  

	private Map<String, Object> convertData( Casystem dataModel){
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put(CaSystemEDM.SYSID, dataModel.getId().getIdsys());
			map.put(CaSystemEDM.SYSDESC, dataModel.getSysdesc());
			map.put(CaSystemEDM.TENANTID, dataModel.getId().getTenants_idTenants());
			return map;
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		
		return null;
	}



	public List<Map<String, Object>> getDataSet() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			
		List<Casystem> collectin =	dao.getAll();
		for (Iterator iterator = collectin.iterator(); iterator.hasNext();) {
			Casystem caSystems = (Casystem) iterator.next();
			Map<String, Object> map = convertData(caSystems);
		result.add(map);
		}
		} catch (Exception e) {
			int i =0;
		}
		return result;
	}



	@Override
	public boolean deleteData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean deleteData(IPkModel primaryKey) {
	 
		Casystem entity =dao.getByPK((CasystemPK)primaryKey);
		dao.delete(entity);
		return true;
	}



	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Casystem entity = (Casystem) data;
			CasystemPK pk= new CasystemPK();
			pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
			entity.setId(pk);
			entity =dao.save(entity);
		return entity;
		} catch (Exception e) {
			return null;
		}
		
	}



	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Casystem founddEntity =dao.getByPK((CasystemPK) pk);
			Casystem newEntity= (Casystem) entity;
			founddEntity.setSysdesc(newEntity.getSysdesc());
			founddEntity = dao.save(founddEntity);
			return founddEntity;
		} catch (Exception e) {
		return entity;
		}
 
	}

	

}
