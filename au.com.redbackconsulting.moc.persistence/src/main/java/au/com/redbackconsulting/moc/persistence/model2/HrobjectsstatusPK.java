package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrobjectsstatus database table.
 * 
 */
@Embeddable
public class HrobjectsstatusPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idHrObjectsStatus;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrobjectsstatusPK() {
	}
	public int getIdHrObjectsStatus() {
		return this.idHrObjectsStatus;
	}
	public void setIdHrObjectsStatus(int idHrObjectsStatus) {
		this.idHrObjectsStatus = idHrObjectsStatus;
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
		if (!(other instanceof HrobjectsstatusPK)) {
			return false;
		}
		HrobjectsstatusPK castOther = (HrobjectsstatusPK)other;
		return 
			(this.idHrObjectsStatus == castOther.idHrObjectsStatus)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHrObjectsStatus;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}