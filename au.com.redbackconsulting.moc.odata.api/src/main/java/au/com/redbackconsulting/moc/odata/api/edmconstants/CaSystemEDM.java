package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;


public class CaSystemEDM extends BaseEDM {
	public static String entity_type_name ="CaSystem";
	public static String sysId ="sysId";
	public static String tenantId="tenantId";
	public static String sysDesc="sysDesc";
	
	
	public CaSystemEDM(String nameSpace){
		super(nameSpace, CaSystemEDM.entity_type_name);
		
	}


	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(sysId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(sysDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}


	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName("sysId"));
		  keyProperties.add(new PropertyRef().setName("tenantId"));
		return keyProperties;
	}
	
 
	
	
//	public  static	Map<String, Object> getEDMData(  CaSystems entity){
//		Map<String, Object> data = new HashMap<String, Object>();
//		
//		if(entity!=null)
//		{
//
//		data.put(CaSystemEDM.sysId, entity.getSystId());
//		data.put(CaSystemEDM.tenantId, entity.getTenantId());
//		data.put(CaSystemEDM.sysDesc,entity.getSystDesc() );
//		return data;
//		}
//		else
//			return null;
//	}

	
	
	
	 
	

}
