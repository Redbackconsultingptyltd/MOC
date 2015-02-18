package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the hrp1000 database table.
 * 
 */
@Embeddable
public class Hrp1001PK implements IPkModel {
	public String getRelatType() {
		return relatType;
	}
	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column
	private int idobjectType;

	@Column
	private int idobjectId;
	
	@Column
	private String relatType;

	@Temporal(TemporalType.DATE)
	private java.util.Date validTo;

	@Temporal(TemporalType.DATE)
	private java.util.Date validFrom;

	@Column 
	private int tenants_idTenants;

//	@Column 
//	private int status;

	public Hrp1001PK() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idobjectId;
		result = prime * result + idobjectType;
		result = prime * result
				+ ((relatType == null) ? 0 : relatType.hashCode());
		result = prime * result + tenants_idTenants;
		result = prime * result
				+ ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hrp1001PK other = (Hrp1001PK) obj;
		if (idobjectId != other.idobjectId)
			return false;
		if (idobjectType != other.idobjectType)
			return false;
		if (relatType == null) {
			if (other.relatType != null)
				return false;
		} else if (!relatType.equals(other.relatType))
			return false;
		if (tenants_idTenants != other.tenants_idTenants)
			return false;
		if (validFrom == null) {
			if (other.validFrom != null)
				return false;
		} else if (!validFrom.equals(other.validFrom))
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		return true;
	}
 
	 
}