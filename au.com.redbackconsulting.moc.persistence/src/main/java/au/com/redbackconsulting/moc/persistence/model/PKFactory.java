package au.com.redbackconsulting.moc.persistence.model;

import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_CASYSTEM;

import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HRHIER;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HRHIERMAP;

import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HROBJECTS;

import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HRP1000;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HRP1001;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_HRRELATIONS;
import static au.com.redbackconsulting.moc.persistence.model.Constants.PK_KEY_TENANTS;
public class PKFactory  {

	
	private PKFactory(){}
	public static PKFactory getInstance(){
		return new PKFactory();
	}
	
	public IPkModel getPKInstance (int key){
		switch (key) {
		case PK_KEY_CASYSTEM:
			return new CaSystemsPk();
		case PK_KEY_HRHIER:
			return new HrHierPk();
		case PK_KEY_HRHIERMAP:
			return new HrHierMapPk();	
		case PK_KEY_HROBJECTS:
			return new HrObjectsPk();
		case PK_KEY_HROBJECTSCONSTRAINTS:
			return new HrObjectsConstraintsPk();
		case PK_KEY_HROBJECTSREL:
			return new HrObjectRelPK();
		case PK_KEY_HROBJECTSSTATUS:
			return new HrObjectsStatusPk();
		case PK_KEY_HRP1000:
			return new HRP1000PK();
		case PK_KEY_HRP1001:
			return new HRP1001PK();
		case PK_KEY_HRRELATIONS:
			return new HrRelationsPk();
		case PK_KEY_TENANTS:
			return new TenantsPk();
		default:
			break;
		}
		return null;
	}
}
