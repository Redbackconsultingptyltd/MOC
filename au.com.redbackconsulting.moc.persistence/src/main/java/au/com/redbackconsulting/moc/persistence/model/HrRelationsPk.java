package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

public class HrRelationsPk implements IPkModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tenantId;
 
	private String relatType;

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
	 * @return the relatType
	 */
	public String getRelatType() {
		return relatType;
	}

	/**
	 * @param relatType the relatType to set
	 */
	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((relatType == null) ? 0 : relatType.hashCode());
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
		HrRelationsPk other = (HrRelationsPk) obj;
		if (relatType == null) {
			if (other.relatType != null)
				return false;
		} else if (!relatType.equals(other.relatType))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
	
	
}
