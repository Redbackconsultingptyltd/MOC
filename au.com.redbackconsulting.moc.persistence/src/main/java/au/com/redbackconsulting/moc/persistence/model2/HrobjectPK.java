package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrobjects database table.
 * 
 */
@Embeddable
public class HrobjectPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idObjectType;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrobjectPK() {
	}
	public int getIdObjectType() {
		return this.idObjectType;
	}
	public void setIdObjectType(int idObjectType) {
		this.idObjectType = idObjectType;
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
		if (!(other instanceof HrobjectPK)) {
			return false;
		}
		HrobjectPK castOther = (HrobjectPK)other;
		return 
			(this.idObjectType == castOther.idObjectType)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idObjectType;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}