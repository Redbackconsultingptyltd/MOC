package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;

import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
 

public interface IBLModel {
	
	public List<Map<String, Object>> getDataSet();
	
	public Map<String, Object> getData(IPkModel primaryKey);
	public boolean deleteData(IPkModel primaryKey);

	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey);
	
	public IDBEntity updateData(IPkModel pk, IDBEntity entity);
	public IDBEntity createData(  IDBEntity entity);

	
}
