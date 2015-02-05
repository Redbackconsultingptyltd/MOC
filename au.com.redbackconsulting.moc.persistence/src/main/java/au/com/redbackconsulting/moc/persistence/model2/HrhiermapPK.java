package au.com.redbackconsulting.moc.persistence.model2;



import javax.persistence.*;

/**
 * The primary key class for the hrhiermap database table.
 * 
 */
@Embeddable
public class HrhiermapPK implements IPkModel {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(insertable=false, updatable=false)
	private int hrHierId;

	private int seqNo;

	@Column(insertable=false, updatable=false)
	private int tenants_idTenants;

	public HrhiermapPK() {
	}
	public int getHrHierId() {
		return this.hrHierId;
	}
	public void setHrHierId(int hrHierId) {
		this.hrHierId = hrHierId;
	}
	public int getSeqNo() {
		return this.seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
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
		if (!(other instanceof HrhiermapPK)) {
			return false;
		}
		HrhiermapPK castOther = (HrhiermapPK)other;
		return 
			(this.hrHierId == castOther.hrHierId)
			&& (this.seqNo == castOther.seqNo)
			&& (this.tenants_idTenants == castOther.tenants_idTenants);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hrHierId;
		hash = hash * prime + this.seqNo;
		hash = hash * prime + this.tenants_idTenants;
		
		return hash;
	}
}