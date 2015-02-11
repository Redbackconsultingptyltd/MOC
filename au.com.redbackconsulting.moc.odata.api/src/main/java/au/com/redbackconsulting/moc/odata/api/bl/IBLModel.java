package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.uri.UriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
 

public interface IBLModel {
	
	public List<IDBEntity> getDataSet();
	
	public <T extends IDBEntity> T  getData(IPkModel primaryKey);
	public boolean deleteData(IPkModel primaryKey);

	public List<Map<String, Object>> getRelatedData(IPkModel primaryKey);
	
	public IDBEntity updateData(IPkModel pk, IDBEntity entity);
	public IDBEntity createData(  IDBEntity entity);
	public List<Map<String, Object>>  convertModelToEDMCollection(List<IDBEntity> entities);
	public Map<String, Object>  convertModelToEDM(IDBEntity entity);
	public IDBEntity	convertEDMDataToModelEDM(Map<String, Object>  edm);
	
	public Map<String, Object> createNew(Map<String, Object> data);	
	
	public Map<String, Object> update(PutMergePatchUriInfo uriinfo,  Map<String, Object> data);	
	
	
	

	
}
