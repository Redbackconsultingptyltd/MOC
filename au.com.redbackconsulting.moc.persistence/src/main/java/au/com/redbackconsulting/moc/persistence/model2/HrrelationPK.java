package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrrelations database table.
 * 
 */
@Embeddable
public class HrrelationPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String relatType;

	private int tenants_idTenants;

	public HrrelationPK() {
	}
	public String getRelatType() {
		return this.relatType;
	}
	public void setRelatType(String relatType) {
		this.relatType = relatType;
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
		if (!(other instanceof HrrelationPK)) {
			return false;
		}
		HrrelationPK castOther = (HrrelationPK)other;
		return 
			this.relatType.equals(castOther.relatType)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.relatType.hashCode();
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}