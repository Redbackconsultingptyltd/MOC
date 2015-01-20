package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hrobjectrel database table.
 * 
 */
@Embeddable
public class HrobjectrelPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idobjectype;

	@Column(insertable=false, updatable=false)
	private int idsobjectype;

	private String idrelatType;

	private int timeConstraints;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrobjectrelPK() {
	}
	public int getIdobjectype() {
		return this.idobjectype;
	}
	public void setIdobjectype(int idobjectype) {
		this.idobjectype = idobjectype;
	}
	public int getIdsobjectype() {
		return this.idsobjectype;
	}
	public void setIdsobjectype(int idsobjectype) {
		this.idsobjectype = idsobjectype;
	}
	public String getIdrelatType() {
		return this.idrelatType;
	}
	public void setIdrelatType(String idrelatType) {
		this.idrelatType = idrelatType;
	}
	public int getTimeConstraints() {
		return this.timeConstraints;
	}
	public void setTimeConstraints(int timeConstraints) {
		this.timeConstraints = timeConstraints;
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
		if (!(other instanceof HrobjectrelPK)) {
			return false;
		}
		HrobjectrelPK castOther = (HrobjectrelPK)other;
		return 
			(this.idobjectype == castOther.idobjectype)
			&& (this.idsobjectype == castOther.idsobjectype)
			&& this.idrelatType.equals(castOther.idrelatType)
			&& (this.timeConstraints == castOther.timeConstraints)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idobjectype;
		hash = hash * prime + this.idsobjectype;
		hash = hash * prime + this.idrelatType.hashCode();
		hash = hash * prime + this.timeConstraints;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}