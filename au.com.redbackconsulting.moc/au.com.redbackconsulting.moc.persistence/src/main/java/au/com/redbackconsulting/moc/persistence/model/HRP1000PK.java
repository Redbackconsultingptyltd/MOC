package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ID class for entity: HRP1000
 *
 */ 
public class HRP1000PK  implements Serializable {   
   
	private Integer tenantId;        
	private String objectType;         
	private String objectId;         
	private Date validTo;         
	private Date validFrom;         
	private String seqNr;
	private static final long serialVersionUID = 1L;
	
	public HRP1000PK() {}

	

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	

	public String getSeqNr() {
		return this.seqNr;
	}

	public void setSeqNr(String seqNr) {
		this.seqNr = seqNr;
	}
	
   
	


	 


 


	/**
	 * @return the tenant
	 */
	public Integer getTenantId() {
		return tenantId;
	}



	/**
	 * @param tenant the tenant to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((objectId == null) ? 0 : objectId.hashCode());
		result = prime * result
				+ ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result + ((seqNr == null) ? 0 : seqNr.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result
				+ ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HRP1000PK other = (HRP1000PK) obj;
		if (objectId == null) {
			if (other.objectId != null)
				return false;
		} else if (!objectId.equals(other.objectId))
			return false;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		if (seqNr == null) {
			if (other.seqNr != null)
				return false;
		} else if (!seqNr.equals(other.seqNr))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
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
