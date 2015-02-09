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

import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.persistence.HrHierMapDAO;
import au.com.redbackconsulting.moc.persistence.HrObjectsConstraintsDAO;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobject;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsconstraint;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class HrObjectsConstraintsBL extends BaseBL{

	private HrObjectsConstraintsDAO dao=new HrObjectsConstraintsDAO();
	public HrObjectsConstraintsBL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IDBEntity> getDataSet() {


		
		List<IDBEntity> result = new ArrayList<IDBEntity>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
		List<Hrobjectsconstraint> entities =	dao.getAll();
		List<IDBEntity> idbEntities = new ArrayList<IDBEntity>();
		idbEntities.addAll(entities);
		return idbEntities;
		} catch (Exception e) {
			
		}
		return result;
		
	}

	@Override
	public IDBEntity getData(IPkModel primaryKeyModel) {


		HrobjectsconstraintPK pk = (HrobjectsconstraintPK) primaryKeyModel;
		 Map<String, Object>  result = new HashMap<String, Object>();
		try {
			HrObjectsConstraintsDAO dao = new HrObjectsConstraintsDAO();
			Hrobjectsconstraint entity =	dao.getByPK(pk);
		result= convertData(entity);
		return (IDBEntity) result;
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
	
	private Map<String, Object> convertData( Hrobjectsconstraint dataModel){

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HrObjectsConstraintsEDM.objectType, dataModel.getId());
			map.put(HrObjectsConstraintsEDM.tableId, dataModel.getTableId());
			map.put(HrObjectsConstraintsEDM.tenantId, dataModel.getTenant());
			map.put(HrObjectsConstraintsEDM.timeConstraint, dataModel.getTimeConstraint());
			
			return map;
			
		} catch (Exception e) {
			return null;
		}
	
	}

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		
		Hrobjectsconstraint entity=dao.getByPK((HrobjectsconstraintPK)primaryKey);
		dao.delete(entity);
		return true;
	}

	@Override
	public IDBEntity createData(IDBEntity data) {
		try {
			Hrobjectsconstraint entity = (Hrobjectsconstraint) data;
			HrobjectsconstraintPK pk= new HrobjectsconstraintPK();
			pk.setTenants_idTenants(entity.getTenant().getTenantPK().getId());
			
			entity.setId(pk);
			entity =dao.saveNew(entity);
		return entity;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		try {
			Hrobjectsconstraint founddEntity =dao.getByPK((HrobjectsconstraintPK) pk);
			Hrobjectsconstraint newEntity= (Hrobjectsconstraint) entity;
			founddEntity.setHrobject(newEntity.getHrobject());
			founddEntity.setTableId(newEntity.getTableId());
			founddEntity.setTimeConstraint(newEntity.getTimeConstraint());
			founddEntity.setTenant(newEntity.getTenant());
			founddEntity.setId(newEntity.getId());
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
			Hrobjectsconstraint idbEntity = (Hrobjectsconstraint) iterator.next();
			result.add(convertData(idbEntity));
		}
		return result;
	} catch (Exception e) {
		return result;
	}
	
}

public Map<String, Object>  convertModelToEDM(IDBEntity entity){

	return convertData((Hrobjectsconstraint) entity);
	
	 
}
 

}
