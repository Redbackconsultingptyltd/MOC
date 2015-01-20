package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrhier database table.
 * 
 */
@Embeddable
public class HrhierPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idHrHier;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrhierPK() {
	}
	public int getIdHrHier() {
		return this.idHrHier;
	}
	public void setIdHrHier(int idHrHier) {
		this.idHrHier = idHrHier;
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
		if (!(other instanceof HrhierPK)) {
			return false;
		}
		HrhierPK castOther = (HrhierPK)other;
		return 
			(this.idHrHier == castOther.idHrHier)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHrHier;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}