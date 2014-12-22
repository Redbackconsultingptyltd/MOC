package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class TenantsEDM extends BaseEDM {
	public TenantsEDM(String namespace) {
		super(namespace, TenantsEDM.entity_name);

	}
	public static String entity_name="Tenants";
	public static String tenantId="tenantId";
	public static String tenantCode="tenantCode";
	public static String name ="name";
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
