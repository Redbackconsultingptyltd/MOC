package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HRP1001EDM extends BaseEDM{

	public HRP1001EDM(String namespace ) {
		super(namespace, HRP1001EDM.entity_name);
		 
	}
	public static String entity_name="Hrp1001";
	public static String tenantId ="tenantId";
	public static String robjectType="robjectType";
	public static String robjectId ="robjectId";
	public static String rsobjectType ="rsobjectType";
	public static String rsobjectId ="rsobjectId";
	public static String relatType ="relatType";
	public static String validTo ="validTo";
	public static String validFrom ="validFrom";
	public static String subType ="subType";	
	public static String status ="status";
	public static String changedOn ="changedOn";
	public static String changedBy ="changedBy";
	public static String guid="guid";
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
