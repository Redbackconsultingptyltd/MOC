package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

public class HRP1000EDM extends BaseEDM {

	public HRP1000EDM(String namespace ) {
		super(namespace, HRP1000EDM.entity_name);
		 
	}
	public static String entity_name="Hrp1000";
	public static String  tenantId="tenantId";
	public static String objectType="objectType";
	public static String objectId="objectId";
	public static String validTo="validTo";
	public static String validFrom="validFrom";
	public static String seqNr="seqNr";
	public static String objectDesc="objectDesc";
	public static String status="status";
	public static String stext="stext";
	public static String changedOn="changedOn";
	public static String changedBy="changedBy";
	public static String guid="guid";
	public static String hrObjectsStatus="hrObjectsStatus";
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
