package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.uri.UriInfo;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;

import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
 

public interface IBLModel {
	
	  
	public Map<String, Object> createNew(Map<String, Object> data);	
	
	public Map<String, Object> update(PutMergePatchUriInfo uriinfo,  Map<String, Object> data);	

	
	public Map<String, Object> read(GetEntityUriInfo uriInfo );	

	public boolean delete(DeleteUriInfo uriInfo );	
	
	public List<Map<String, Object>> readSet( );	
	
	
	

	
}
