package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HrObjectsConstraintsEDM extends BaseEDM {
	public HrObjectsConstraintsEDM(String namespace ) {
		super(namespace, HrObjectsConstraintsEDM.entity_name);
		// TODO Auto-generated constructor stub
	}
	public static String entity_name="HrObjectsConstraints";
	public static String tenantId="tenantId";
	public static String objectType="objectType";
	public static String tableId="tableId";
	public static String timeConstraint="timeConstraint";
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
