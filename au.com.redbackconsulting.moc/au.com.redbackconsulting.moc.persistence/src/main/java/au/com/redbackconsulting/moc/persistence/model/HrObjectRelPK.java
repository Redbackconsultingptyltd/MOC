package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

/**
 * ID class for entity: HrObjectRel
 *
 */ 
public class HrObjectRelPK  implements Serializable {   
   
	private Integer tenantId;
		private String objectType;         
	private String relatType;         
	private String sObjectType;
	private static final long serialVersionUID = 1L;

	public HrObjectRelPK() {}

	

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	

	public String getRelatType() {
		return this.relatType;
	}

	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}
	

	public String getSObjectType() {
		return this.sObjectType;
	}

	public void setSObjectType(String sObjectType) {
		this.sObjectType = sObjectType;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result
				+ ((relatType == null) ? 0 : relatType.hashCode());
		result = prime * result
				+ ((sObjectType == null) ? 0 : sObjectType.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
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
		HrObjectRelPK other = (HrObjectRelPK) obj;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		if (relatType == null) {
			if (other.relatType != null)
				return false;
		} else if (!relatType.equals(other.relatType))
			return false;
		if (sObjectType == null) {
			if (other.sObjectType != null)
				return false;
		} else if (!sObjectType.equals(other.sObjectType))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}



	/**
	 * @return the tenantId
	 */
	public Integer getTenantId() {
		return tenantId;
	}



	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}



	/**
	 * @return the sObjectType
	 */
	public String getsObjectType() {
		return sObjectType;
	}



	/**
	 * @param sObjectType the sObjectType to set
	 */
	public void setsObjectType(String sObjectType) {
		this.sObjectType = sObjectType;
	}
	
   
	 
   
   
}
