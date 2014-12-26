package au.com.redbackconsulting.moc.odata.api.bl;

import java.util.List;
import java.util.Map;
 

public interface IBLModel {
	
	public List<Map<String, Object>> getDataSet();
	public Map<String, Object> getData(Map<String,	Object> keyMap);
	public boolean deleteData(Map<String, Object> keyMap);
	public Map<String, Object> updateData(Map<String, Object> valueMap, Map<String, Object> keyMap);
	public Map<String, Object> createData(  Map<String, Object> valueMap);

}
