package au.com.redbackconsulting.moc.odata.api;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;

import au.com.redbackconsulting.moc.odata.api.bl.BLModelFactory;
  
import au.com.redbackconsulting.moc.odata.api.bl.IBLModel; 
import au.com.redbackconsulting.moc.persistence.model.ICaSystemPK;
import au.com.redbackconsulting.moc.persistence.model.ITenantsPK;
import au.com.redbackconsulting.moc.persistence.model.PKFactory;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;




import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_TENANTS;



public class MyODataSingleProcessor extends ODataSingleProcessor {

//	private DataStore dataStore = new DataStore();
	private BLModelFactory bmf= BLModelFactory.getInstance();
	@Override
	public ODataResponse readEntity(GetEntityUriInfo uriInfo, String contentType)
			throws ODataException {
		
		if (uriInfo.getNavigationSegments().size() == 0) {
			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
		if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
				String sysId = getKeyValueString(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue (uriInfo.getKeyPredicates().get(1));
				
				IBLModel blModel =bmf.getInstance(ENTITY_KEY_CASYSTEM);
				ICaSystemPK pk  = (ICaSystemPK) PKFactory.getInstance().getPKInstance(PK_KEY_CASYSTEM);
				pk.setSystId(sysId);
				pk.setTenantId(new Integer(tenantId));
				Map<String, Object> data = blModel.getData(pk);
//				Map<String, Object> data = dataStore.getCar(id);
				URI serviceRoot = getContext().getPathInfo()
						.getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet,
						data, propertiesBuilder.build());
		} else if(ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())){
				int tenantId = getKeyValue (uriInfo.getKeyPredicates().get(0));
			
			IBLModel blModel =bmf.getInstance(ENTITY_KEY_TENANTS);
			ITenantsPK pk  = (ITenantsPK) PKFactory.getInstance().getPKInstance(PK_KEY_TENANTS);
			pk.setTenantId(new Integer(tenantId));
			Map<String, Object> data = blModel.getData(pk);
 
			URI serviceRoot = getContext().getPathInfo()
					.getServiceRoot();
			ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
					.serviceRoot(serviceRoot);
			return EntityProvider.writeEntry(contentType, entitySet,
					data, propertiesBuilder.build());
		}
		}
		return null;

//		if (uriInfo.getNavigationSegments().size() == 0) {
//			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
//
//			if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				Map<String, Object> data = dataStore.getCar(id);
//
//				if (data != null) {
//					URI serviceRoot = getContext().getPathInfo()
//							.getServiceRoot();
//					ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//							.serviceRoot(serviceRoot);
//
//					return EntityProvider.writeEntry(contentType, entitySet,
//							data, propertiesBuilder.build());
//				}
//			} else if (ENTITY_SET_NAME_MANUFACTURERS
//					.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				Map<String, Object> data = dataStore.getManufacturer(id);
//
//				if (data != null) {
//					URI serviceRoot = getContext().getPathInfo()
//							.getServiceRoot();
//					ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//							.serviceRoot(serviceRoot);
//
//					return EntityProvider.writeEntry(contentType, entitySet,
//							data, propertiesBuilder.build());
//				}
//			} else if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				// Map<String, Object> data = dataStore.getSan(id);
//
//			} else if (ENTITY_SET_NAME_CASYSTEMS.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				Map<String, Object> data = dataStore.getCaSystem(id);
//
//				if (data != null) {
//					URI serviceRoot = getContext().getPathInfo()
//							.getServiceRoot();
//					ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//							.serviceRoot(serviceRoot);
//
//					return EntityProvider.writeEntry(contentType, entitySet,
//							data, propertiesBuilder.build());
//				}
//			}
//			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//
//		} else if (uriInfo.getNavigationSegments().size() == 1) {
//			// navigation first level, simplified example for illustration
//			// purposes only
//			EdmEntitySet entitySet = uriInfo.getTargetEntitySet();
//			if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
//				int carKey = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getTargetEntitySet(),
//						dataStore.getManufacturer(carKey),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//		}
//
//		throw new ODataNotImplementedException();
	}

	

	// Implement MyODataSingleProcessor.readEntitySet(GetEntitySetUriInfo
	// uriParserResultInfo) by overriding the corresponding method of the
	// ODataSingleProcessor

	public ODataResponse readEntitySet(GetEntitySetUriInfo uriInfo,
			String contentType) throws ODataException {

		EdmEntitySet entitySet;

		if (uriInfo.getNavigationSegments().size() == 0) {
			entitySet = uriInfo.getStartEntitySet();

			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
				List<Map<String, Object>> data =blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}  else if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				List<Map<String, Object>> data =blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}
			


			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

		} else if (uriInfo.getNavigationSegments().size() == 1) {
			// navigation first level, simplified example for illustration
			// purposes only
			entitySet = uriInfo.getTargetEntitySet();

			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				String sysId = getKeyValueString(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				ITenantsPK pk  = (ITenantsPK) PKFactory.getInstance().getPKInstance(PK_KEY_TENANTS);
				pk.setTenantId(new Integer(tenantId));
				Map<String, Object> data = blModel.getData(pk);
				
				List<Map<String, Object>> result1 = new ArrayList<Map<String, Object>>();
				result1.add(data);
//
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						result1,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
 	}

			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		} else if (uriInfo.getNavigationSegments().size() == 1) {
			// navigation first level, simplified example for illustration
			// purposes only
			entitySet = uriInfo.getTargetEntitySet();

//			if (ENTITY_SET_NAME_CASYSTEMS.equals(entitySet.getName())) {
//				int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				List<Map<String, Object>> caSystems = new ArrayList<Map<String, Object>>();
//				caSystems.addAll(dataStore.getCaSystems());
//
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						caSystems,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}

			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		}

		throw new ODataNotImplementedException();
	}

	private int getKeyValue(KeyPredicate key) throws ODataException {
		EdmProperty property = key.getProperty();
		EdmSimpleType type = (EdmSimpleType) property.getType();
		return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
				property.getFacets(), Integer.class);
	}
	private String getKeyValueString(KeyPredicate key )throws ODataException {
		EdmProperty property = key.getProperty();
		EdmSimpleType type = (EdmSimpleType) property.getType();
		return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
				property.getFacets(), String.class);
	}
}
