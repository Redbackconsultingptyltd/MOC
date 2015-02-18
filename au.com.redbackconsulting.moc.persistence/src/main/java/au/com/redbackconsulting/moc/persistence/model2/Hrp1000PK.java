package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrp1000 database table.
 * 
 */
@Embeddable
public class Hrp1000PK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column
	private int idobjectType;

	@Column
	private int idobjectId;

	@Temporal(TemporalType.DATE)
	private java.util.Date validTo;

	@Temporal(TemporalType.DATE)
	private java.util.Date validFrom;

	@Column 
	private int tenants_idTenants;

//	@Column 
//	private int status;

	public Hrp1000PK() {
	}
	public int getIdobjectType() {
		return this.idobjectType;
	}
	public void setIdobjectType(int idobjectType) {
		this.idobjectType = idobjectType;
	}
	public int getIdobjectId() {
		return this.idobjectId;
	}
	public void setIdobjectId(int idobjectId) {
		this.idobjectId = idobjectId;
	}
	public java.util.Date getValidTo() {
		return this.validTo;
	}
	public void setValidTo(java.util.Date validTo) {
		this.validTo = validTo;
	}
	public java.util.Date getValidFrom() {
		return this.validFrom;
	}
	public void setValidFrom(java.util.Date validFrom) {
		this.validFrom = validFrom;
	}
	public int getTenants_idTenants() {
		return this.tenants_idTenants;
	}
	public void setTenants_idTenants(int tenants_idTenants) {
		this.tenants_idTenants = tenants_idTenants;
	}
//	public int getStatus() {
//		return this.status;
//	}
//	public void setStatus(int status) {
//		this.status = status;
//	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Hrp1000PK)) {
			return false;
		}
		Hrp1000PK castOther = (Hrp1000PK)other;
		return 
			(this.idobjectType == castOther.idobjectType)
			&& (this.idobjectId == castOther.idobjectId)
			&& this.validTo.equals(castOther.validTo)
			&& this.validFrom.equals(castOther.validFrom)
			&& (this.tenants_idTenants == castOther.tenants_idTenants)
//			&& (this.status == castOther.status)
			;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idobjectType;
		hash = hash * prime + this.idobjectId;
		hash = hash * prime + this.validTo.hashCode();
		hash = hash * prime + this.validFrom.hashCode();
		hash = hash * prime + this.tenants_idTenants;
//		hash = hash * prime + this.status;
		
		return hash;
	}
}