package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HrHierMapEDM  extends BaseEDM{

	
	public HrHierMapEDM(String namespace ) {
		super(namespace, HrHierEDM.entity_name);
		 
	}
	public static String hierId ="hierId";
	public static String tenantId="tenantId";
	public static String seqNo="seqno";
	public static String objectType;
	public static String relatType;
	public static String sObjType;
	public static String skip;
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
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EntitySet getEntitySet() {
		// TODO Auto-generated method stub
		return null;
	}
 
 
} 
