package au.com.redbackconsulting.moc.odata.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmConcurrencyMode;
import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.EdmTargetPath;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.AssociationSetEnd;
import org.apache.olingo.odata2.api.edm.provider.ComplexProperty;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.CustomizableFeedMappings;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityContainer;
import org.apache.olingo.odata2.api.edm.provider.EntityContainerInfo;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.api.exception.ODataException;

import au.com.redbackconsulting.moc.odata.api.edmconstants.BaseEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.EntityTypeFactory;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;



public class MyEdmProvider extends EdmProvider  implements IMyEdmProvider{
	

	
 
	  private static final String NAMESPACE = "au.com.redbackconsulting.odata2.ODataMoc";
      private static final String ENTITY_CONTAINER = "ODataMOCEntityContainer";
     
        
      EntityTypeFactory entityFactory = EntityTypeFactory.getInstance(NAMESPACE);

 
	@Override
	public List<Schema> getSchemas() throws ODataException {
		 
		List<Schema> schemas = new ArrayList<Schema>();
		Schema schema = new Schema();
		schema.setNamespace(NAMESPACE);
		List<EntityType> entityTypes = new ArrayList<EntityType>();
				BaseEDM caSystemEDM = entityFactory.getEDM(ENTITY_KEY_CASYSTEM);
		entityTypes.add(caSystemEDM.getEntityType());

		BaseEDM hrHierEDM = entityFactory.getEDM(ENTITY_KEY_HRHIER);
		entityTypes.add(hrHierEDM.getEntityType());
		
		BaseEDM hrHierMapEDM = entityFactory.getEDM(ENTITY_KEY_HRHIERMAP);
		entityTypes.add(hrHierMapEDM.getEntityType());
		
		BaseEDM hrObjectConstraintsEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSCONSTRAINTS);
		entityTypes.add(hrObjectConstraintsEDM.getEntityType());
		
		BaseEDM hrObjectsRelEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSREL); 
		entityTypes.add(hrObjectsRelEDM.getEntityType());
		
		BaseEDM hrObjectsEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTS);
		entityTypes.add(hrObjectsEDM.getEntityType());
		
		BaseEDM hrObjectsStutusEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSSTATUS);
		entityTypes.add(hrObjectsStutusEDM.getEntityType());
		
		BaseEDM hrP1000EDM = entityFactory.getEDM(ENTITY_KEY_HRP1000);
		entityTypes.add(hrP1000EDM.getEntityType());
		
		BaseEDM hrP1001EDM= entityFactory.getEDM(ENTITY_KEY_HRP1001); 
		entityTypes.add(hrP1001EDM.getEntityType());
		
		BaseEDM hrRelationsEDM= entityFactory.getEDM(ENTITY_KEY_HRRELATIONS);
		entityTypes.add(hrRelationsEDM.getEntityType());
		
		BaseEDM tenantEDM = entityFactory.getEDM(ENTITY_KEY_TENANTS);
		entityTypes.add(tenantEDM.getEntityType());
		schema.setEntityTypes(entityTypes);


//		List<ComplexType> complexTypes = new ArrayList<ComplexType>();
//		complexTypes.add(getComplexType(COMPLEX_TYPE));
//		schema.setComplexTypes(complexTypes);

//		List<Association> associations = new ArrayList<Association>();
//		associations.add(caSystemEDM.getAssociation(tenantEDM.getFullQualifiedName()));
//		schema.setAssociations(associations);
//		
//		associations.add(e)

		List<EntityContainer> entityContainers = new ArrayList<EntityContainer>();
		EntityContainer entityContainer = new EntityContainer();
		entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);
//		entityContainer.
		List<EntitySet> entitySets = new ArrayList<EntitySet>();
		
		entitySets.add(caSystemEDM.getEntitySet( ));
//		entitySets.add(hrHierEDM.getEntitySet());
//		entitySets.add(hrHierMapEDM.getEntitySet());
//		entitySets.add(hrObjectsRelEDM.getEntitySet());
//		entitySets.add(hrObjectConstraintsEDM.getEntitySet());
//		entitySets.add(hrObjectsEDM.getEntitySet());
//		entitySets.add(hrObjectsStutusEDM.getEntitySet());
//		entitySets.add(hrP1000EDM.getEntitySet());
//		entitySets.add(hrP1001EDM.getEntitySet() );
//		entitySets.add(hrRelationsEDM.getEntitySet());
		entitySets.add(tenantEDM.getEntitySet( ));
		entityContainer.setEntitySets(entitySets);

//		List<AssociationSet> associationSets = new ArrayList<AssociationSet>();
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_CAR_MANUFACTURER, ENTITY_SET_NAME_MANUFACTURERS, ROLE_1_2));
//		entityContainer.setAssociationSets(associationSets);

		entityContainers.add(entityContainer);
		schema.setEntityContainers(entityContainers);

		schemas.add(schema);

		return schemas;
	}




	@Override
	public EntityType getEntityType(FullQualifiedName edmFQName)
			throws ODataException {
		if (NAMESPACE.equals(edmFQName.getNamespace())) {
			  if (edmFQName.getName().equals(ENTITY_TYPE_NAME_CASYSTEM)) {
			EntityType entityType =entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getEntityType();

		return entityType; 	
				
			  }
	}
return null;
	}


	@Override
	public EntitySet getEntitySet(String entityContainer, String name)
			throws ODataException {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ENTITY_SET_NAME_CASYSTEM.equals(name)) {
			      return new EntitySet().setName(name).setEntityType(entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getFullQualifiedName());
			    }  
			  }
			  return null;
	}




	@Override
	public EntityContainerInfo getEntityContainerInfo(String name)
			throws ODataException {
		 if (name == null || "ODataMOCEntityContainer".equals(name)) {
			    return new EntityContainerInfo().setName("ODataMOCEntityContainer").setDefaultEntityContainer(true);
			  }

			  return null;
	}




	@Override
	public ComplexType getComplexType(FullQualifiedName edmFQName)
			throws ODataException {
		// TODO Auto-generated method stub
		return super.getComplexType(edmFQName);
	}




	@Override
	public Association getAssociation(FullQualifiedName edmFQName)
			throws ODataException {
		// TODO Auto-generated method stub
		return super.getAssociation(edmFQName);
	}




	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association, String sourceEntitySetName,
			String sourceEntitySetRole) throws ODataException {
		// TODO Auto-generated method stub
		return super.getAssociationSet(entityContainer, association,
				sourceEntitySetName, sourceEntitySetRole);
	}


}
