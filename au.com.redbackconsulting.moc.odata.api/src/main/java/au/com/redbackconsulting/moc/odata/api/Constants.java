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
 	public static final String ASSOCIATION_NAME_HRHIER_TENANT="HrHier_Tenants_Tenants_HrHier";
 	public static final String ASSOCIATION_NAME_HRHIER_HRHIERMAP="HrHier_HrHierMap_HrHierMap_HrHier";
 	// i am write some code here only variable
	public static final String ASSOCIATION_NAME_HROBJECTSCONSTRAINT_TENANT="HrObjectsConstraint_Tenants_HrObjectsConstraint_Tenants";
	public static final String ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTSSTATUS="HrObjectsConstraint_HrObjectsStatus_HrObjectsConstraint_HrObjectsStatus";
	public static final String ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS="HrObjectsConstraint_HrObjects_HrObjectsConstraint_HrObjects";
	
	public static final String ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTS="HrObjectsStatus_HrObjects_HrObjectsStatus_HrObjects";
	public static final String ASSOCIATION_NAME_HROBJECTSSTATUS_HRP1000="HrObjectsStatus_Hrp1000_HrObjectsStatus_Hrp1000";
	
	public static final String ASSOCIATION_NAME_HRRELATIONS_HRP1001="HrRelations_Hrp1001_HrRelations_Hrp1001";
	public static final String ASSOCIATION_NAME_HRRELATIONS_HROBJECTREL="HrRelations_HrObjectRel_HrRelations_HrObjectRel";
	
	public static final String ASSOCIATION_NAME_HRP1001_HROBJECTS="Hrp1001_HrObjects_Hrp1001_HrObjects";
	public static final String ASSOCIATION_NAME_HRP1001_HRP1000="Hrp1001_Hrp1000_Hrp1001_Hrp1000";
	
	
 	
 	
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


public static final String ROLE_CASYSTEMS_TENANTS_1_1 = "CaSystem_to_Tenant";
public static final String ROLE_TENANTS_CASYSTEMS_1_2 = "Tenant_CaSystems";

}
