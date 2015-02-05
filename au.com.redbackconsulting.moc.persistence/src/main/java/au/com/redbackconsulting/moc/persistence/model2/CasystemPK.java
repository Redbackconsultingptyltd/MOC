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

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int idsys;

	@Column 
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasystemPK other = (CasystemPK) obj;
		if (idsys != other.idsys)
			return false;
		if (tenants_idTenants != other.tenants_idTenants)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idsys;
		result = prime * result + tenants_idTenants;
		return result;
	}
}