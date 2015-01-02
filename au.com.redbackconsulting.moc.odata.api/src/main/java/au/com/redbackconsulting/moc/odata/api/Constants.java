package au.com.redbackconsulting.moc.odata.api;

import org.apache.olingo.odata2.api.edm.FullQualifiedName;

public class Constants {
	
	  public static final String NAMESPACE = "au.com.redbackconsulting.odata2.ODataMoc";
 
      public static final String ENTITY_CONTAINER = "ODataMOCEntityContainer";
     
	
	 public static final int ENTITY_KEY_CASYSTEM=1;
     public static final int ENTITY_KEY_HRHIER=2;
     public static final int ENTITY_KEY_HRHIERMAP=3;
     public static final int ENTITY_KEY_HROBJECTSREL=4;
     public static final int ENTITY_KEY_HROBJECTSCONSTRAINTS=5;
     public static final int ENTITY_KEY_HROBJECTS=6;
     public static final int ENTITY_KEY_HROBJECTSSTATUS=7;
     public static final int ENTITY_KEY_HRP1000=8;
     public static final int ENTITY_KEY_HRP1001=9;
     public static final int ENTITY_KEY_HRRELATIONS=10;
     public static final int ENTITY_KEY_TENANTS=11;
     
     
     public static String ENTITY_TYPE_NAME_CASYSTEM ="CaSystem";
 	public static String ENTITY_SET_NAME_CASYSTEM="CaSystems";
 	public static String ASSOCIATION_NAME_CASYSTEM_TENANT="CaSystems_Tenants_Tenants_CaSystems";
 	public static final FullQualifiedName ASSOCIATION_CASYSTEM_TENANT=new FullQualifiedName(NAMESPACE, ASSOCIATION_NAME_CASYSTEM_TENANT);
 	 
 	
 	public static final String ASSOCIATION_SET_CASYSTEM_TENANT="CaSystems_Tenants";
	

public static String ENTITY_TYPE_NAME_HRHIER="HrHier";
public static String ENTITY_SET_NAME_HRHIER="HrHiers";
public  static   String ASSOCIATION_SET_HRHIER_1 = "CaSystems_Tenants";

public static String ENTITY_TYPE_NAME_HRHIERMAP="HrHierMap";
public static String ENTITY_SET_NAME_HRHIERMAP="HrHierMaps";

public static String ENTITY_TYPE_NAME_HROBJECTREL="HrObjectRel";
public static String ENTITY_SET_NAME_HROBJECTREL="HrObhectRelSet";

public static String ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS="HrObjectsConstraints";
public static String ENTITY_SET_NAME_HROBJECTSCONSTRAINTS="HrObjectsConstraintsSet";
public static String ENTITY_TYPE_NAME_HROBJECTS="HrObjects";
public static String ENTITY_SET_NAME_HROBJECTS="HrObjectsSet";

public static String ENTITY_TYPE_NAME_HROBJECTSSTATUS="HrObjectsStatus";
public static String ENTITY_SET_NAME_HROBJECTSSTATUS="HrObjectsStatusSet";

public static String ENTITY_TYPE_NAME_HRP1000="HRP1000";
public static String ENTITY_SET_NAME_HRP1000="HRP1000s";

public static String ENTITY_TYPE_NAME_HRP1001="HRP1001";
public static String ENTITY_SET_NAME_HRP1001="HRP1001s";

public static String ENTITY_TYPE_NAME_HRRELATIONS="HrRelations";
public static String ENTITY_SET_NAME_HRRELATIONS="HrRelationsSet";

public static String ENTITY_TYPE_NAME_TENANTS="Tenants";
public static String ENTITY_SET_NAME_TENANTS="TenantsSet";
}
