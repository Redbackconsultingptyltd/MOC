package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.List;

import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;

abstract public class BaseEDM {
	
private FullQualifiedName fqn = null;
private EntityTypeFactory factory=null;
public EntityTypeFactory getFactory() {
	return factory;
}

protected String entitySetName ;
private String entityTypeName;
	public BaseEDM(String namespace,  String entityTypeName,String entitySetName, EntityTypeFactory factory){
		fqn= new FullQualifiedName(namespace,	entityTypeName);
		this.entitySetName=entitySetName;
		this.entityTypeName=entityTypeName;
		this.factory=factory;
	}
	
	
	public String getEntityTypeName(){
		
		return this.entityTypeName;
	}

public String getEntitySetName(){
		
		return this.entitySetName;
	}

	public FullQualifiedName getFullQualifiedName( ){
		return fqn;
	
	}
	
	abstract public List<Property> getProperties() ;
	abstract public  List<PropertyRef> getKeys() ;
	abstract public List<NavigationProperty> getNavigations();
	
	public EntityType getEntityType( ){
		 
				
			//Properties
			
			  List<Property> properties = getProperties();
//			  properties.add(new SimpleProperty().setName(sysId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
//			  properties.add(new SimpleProperty().setName(tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
//			  properties.add(new SimpleProperty().setName(sysDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			  //Navigation  Properties
			  
			  List<NavigationProperty> navigationProperties = getNavigations();
			  
			  //key
			  List<PropertyRef> keyProperties = getKeys();
//			  keyProperties.add(new PropertyRef().setName("sysId"));
//			  keyProperties.add(new PropertyRef().setName("tenantId"));
//				
			  Key key = new Key().setKeys(keyProperties);
			  
			  return new EntityType().setName(fqn.getName())
					  .setProperties(properties)
					  .setHasStream(true)
					  .setKey(key).setNavigationProperties(navigationProperties);
			  
		}
	
	
	
	abstract public Association getAssociation (  FullQualifiedName relatedEntity  );
	abstract public AssociationSet getAssociationSet ( String entityContainer,
			FullQualifiedName association 
			 );
	
	 public EntitySet getEntitySet(   ){
		 return new EntitySet().setName(entitySetName).setEntityType(getFullQualifiedName());
	 };
	
}
