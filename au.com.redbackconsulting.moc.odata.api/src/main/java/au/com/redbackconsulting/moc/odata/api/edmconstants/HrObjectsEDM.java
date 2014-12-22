package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HrObjectsEDM  extends BaseEDM{
	public HrObjectsEDM(String namespace   ) {
		super(namespace,HrObjectsEDM.entity_name);
		// TODO Auto-generated constructor stub
	}
	public static String entity_name="HrObjects";
	public static String  tenantId="tenantId";
	public static String  objectType="objectType";
	public static String  systId ="systId";
	public static String  sObjectType ="sObjectType";
	@Override
	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<PropertyRef> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}
 
	
}
