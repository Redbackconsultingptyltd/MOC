package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

public class HrHierMapPk implements IHrHierMapPk, Serializable {
	
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hierId;
 
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hierId == null) ? 0 : hierId.hashCode());
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
		HrHierMapPk other = (HrHierMapPk) obj;
		if (hierId == null) {
			if (other.hierId != null)
				return false;
		} else if (!hierId.equals(other.hierId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	/**
	 * @return the hierId
	 */
	public String getHierId() {
		return hierId;
	}

	/**
	 * @param hierId the hierId to set
	 */
	public void setHierId(String hierId) {
		this.hierId = hierId;
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

	private Integer tenantId;

}
