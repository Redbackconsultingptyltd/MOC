package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HrRelationsEDM extends BaseEDM {

	public HrRelationsEDM(String namespace ) {
		super(namespace, HrRelationsEDM.entity_name);
	}
	public static String entity_name="HrRelations";
	public static String tenantId="tenantId";
	public static String relatType ="relatType";
	public static String relatTypeT="relatTypeT";
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
