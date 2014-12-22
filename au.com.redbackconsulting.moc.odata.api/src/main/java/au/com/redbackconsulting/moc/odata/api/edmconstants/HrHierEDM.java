package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

public class HrHierEDM  extends BaseEDM{

	public HrHierEDM(String namespace) {
		super(namespace, HrHierEDM.entity_name);
		 
	}
	
public static String entity_name="HrHier";
	public static String hierId ="hierId";
	public static String tenantId="tenantId";
	public static String hierDesc="hierDesc";
	public static String hrHierMap="hrHierMap";
	@Override
	public List<Property> getProperties() {
		
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hrHierMap).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
		
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName("sysId"));
		  keyProperties.add(new PropertyRef().setName("tenantId"));
		return keyProperties;
	}
	
}
