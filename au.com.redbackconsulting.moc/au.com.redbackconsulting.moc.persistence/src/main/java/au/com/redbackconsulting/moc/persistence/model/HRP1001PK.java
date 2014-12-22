package au.com.redbackconsulting.moc.persistence.model;

import java.io.Serializable;

/**
 * ID class for entity: HRP1001
 *
 */ 
public class HRP1001PK  implements Serializable {   
   
	         
	private Integer tenantId;
	
	private String robjectType;         
	
	private String robjectId;
	private String rsobjectType;
	private String rsobjectId;
	
	public String getSobjectType() {
		return rsobjectType;
	}

	public void setSobjectType(String sobjectType) {
		this.rsobjectType = sobjectType;
	}

	public String getSobjectId() {
		return rsobjectId;
	}

	public void setSobjectId(String sobjectId) {
		this.rsobjectId = sobjectId;
	}

	private static final long serialVersionUID = 1L;

	public HRP1001PK() {}

	public String getRobjectType() {
		return robjectType;
	}



	public void setRobjectType(String robjectType) {
		this.robjectType = robjectType;
	}



	public String getRobjectId() {
		return robjectId;
	}



	public void setRobjectId(String robjectId) {
		this.robjectId = robjectId;
	}

	
 
 
   

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((robjectId == null) ? 0 : robjectId.hashCode());
		result = prime * result
				+ ((robjectType == null) ? 0 : robjectType.hashCode());
		result = prime * result
				+ ((rsobjectId == null) ? 0 : rsobjectId.hashCode());
		result = prime * result
				+ ((rsobjectType == null) ? 0 : rsobjectType.hashCode());
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
		HRP1001PK other = (HRP1001PK) obj;
		if (robjectId == null) {
			if (other.robjectId != null)
				return false;
		} else if (!robjectId.equals(other.robjectId))
			return false;
		if (robjectType == null) {
			if (other.robjectType != null)
				return false;
		} else if (!robjectType.equals(other.robjectType))
			return false;
		if (rsobjectId == null) {
			if (other.rsobjectId != null)
				return false;
		} else if (!rsobjectId.equals(other.rsobjectId))
			return false;
		if (rsobjectType == null) {
			if (other.rsobjectType != null)
				return false;
		} else if (!rsobjectType.equals(other.rsobjectType))
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
	 * @return the rsobjectType
	 */
	public String getRsobjectType() {
		return rsobjectType;
	}

	/**
	 * @param rsobjectType the rsobjectType to set
	 */
	public void setRsobjectType(String rsobjectType) {
		this.rsobjectType = rsobjectType;
	}

	/**
	 * @return the rsobjectId
	 */
	public String getRsobjectId() {
		return rsobjectId;
	}

	/**
	 * @param rsobjectId the rsobjectId to set
	 */
	public void setRsobjectId(String rsobjectId) {
		this.rsobjectId = rsobjectId;
	}

   
}
