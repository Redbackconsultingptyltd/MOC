package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

public class HrHierMapPk implements IHrHierMapPk, Serializable {
	
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hiermapId;
 
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hiermapId == null) ? 0 : hiermapId.hashCode());
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
		if (hiermapId == null) {
			if (other.hiermapId != null)
				return false;
		} else if (!hiermapId.equals(other.hiermapId))
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
		return hiermapId;
	}

	/**
	 * @param hierId the hierId to set
	 */
	public void setHierId(String hierId) {
		this.hiermapId = hiermapId;
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
