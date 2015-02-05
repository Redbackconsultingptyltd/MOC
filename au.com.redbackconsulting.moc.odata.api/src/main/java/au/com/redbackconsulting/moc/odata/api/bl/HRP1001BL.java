package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;

public class HRP1001BL extends BaseBL {

	public HRP1001BL(IBLModelFactory bmf) {
		super(bmf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Map<String, Object>> getDataSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getData(IPkModel primaryKeyModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteData(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return false;
	}
  

	@Override
	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteData(IPkModel primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDBEntity createData(IDBEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDBEntity updateData(IPkModel pk, IDBEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
