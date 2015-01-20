package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrobjectsconstraints database table.
 * 
 */
@Embeddable
public class HrobjectsconstraintPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int hrObject;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrobjectsconstraintPK() {
	}
	public int getHrObject() {
		return this.hrObject;
	}
	public void setHrObject(int hrObject) {
		this.hrObject = hrObject;
	}
	public int getTenants_idTenants() {
		return this.tenants_idTenants;
	}
	public void setTenants_idTenants(int tenants_idTenants) {
		this.tenants_idTenants = tenants_idTenants;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HrobjectsconstraintPK)) {
			return false;
		}
		HrobjectsconstraintPK castOther = (HrobjectsconstraintPK)other;
		return 
			(this.hrObject == castOther.hrObject)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hrObject;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}