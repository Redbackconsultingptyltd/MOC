package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HrObjectsStatusEDM extends BaseEDM {


	public HrObjectsStatusEDM(String namespace ) {
		super(namespace, HrObjectsStatusEDM.entity_name);
		 
	}
	public static String entity_name="HrObjectsStatus";
	public static String tenantId ="tenantId";
	public static String status="status";
	public static String description ="description";
	public static String hRP1001="hRP1001;";
	public static String hRP1000 ="hRP1000";
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
