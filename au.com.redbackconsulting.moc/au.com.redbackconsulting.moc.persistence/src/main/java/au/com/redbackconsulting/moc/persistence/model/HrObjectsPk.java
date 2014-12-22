package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

public class HrObjectsPk implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tenantId;
	private String objectType;
	
	public HrObjectsPk() {
		 
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
				+ ((objectType == null) ? 0 : objectType.hashCode());
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
		HrObjectsPk other = (HrObjectsPk) obj;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}


}
