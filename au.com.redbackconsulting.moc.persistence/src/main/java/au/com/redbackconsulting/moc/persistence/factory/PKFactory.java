package au.com.redbackconsulting.moc.persistence.factory;

import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;
import au.com.redbackconsulting.moc.persistence.model2.IPkModel;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_TENANTS;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_CASYSTEMS;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIER;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIERMAP;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTCONSTRAINTS;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTS;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTSREL;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTSTATUS;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRP1000;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRP1001;
import  static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRRELATIONS;





public class PKFactory {

	public static PKFactory getInstance() {
		return new PKFactory();
	}
	
	
	
	public IPkModel getPKModel (int key){
		switch (key) {
		case PERSISTENCE_TENANTS:
			return new TenantPK();
		case PERSISTENCE_CASYSTEMS:
			return new CasystemPK();
		case PERSISTENCE_HRHIER:
			return new HrhierPK();
		case PERSISTENCE_HRHIERMAP:
			return new HrhiermapPK();
		case PERSISTENCE_HROBJECTCONSTRAINTS:
			return new HrobjectsconstraintPK();
		case PERSISTENCE_HROBJECTS:
			return new HrobjectPK();
		case PERSISTENCE_HROBJECTSREL:
			return new HrobjectrelPK();
		case PERSISTENCE_HROBJECTSTATUS:
			return new HrobjectsstatusPK();
		case PERSISTENCE_HRP1000:
			return new Hrp1000PK();
//		case HRP1001:
//			return new TenantPK();
		case PERSISTENCE_HRRELATIONS:
			return new HrrelationPK();
			

		default:
			break;
		}
		return null;
		
	}
}
