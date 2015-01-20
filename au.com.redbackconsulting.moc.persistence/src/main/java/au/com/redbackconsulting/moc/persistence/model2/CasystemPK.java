package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the casystems database table.
 * 
 */
@Embeddable
public class CasystemPK implements IPkModel, Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idsys;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public CasystemPK() {
	}
	public int getIdsys() {
		return this.idsys;
	}
	public void setIdsys(int idsys) {
		this.idsys = idsys;
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
		if (!(other instanceof CasystemPK)) {
			return false;
		}
		CasystemPK castOther = (CasystemPK)other;
		return 
			(this.idsys == castOther.idsys)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idsys;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}