package au.com.redbackconsulting.moc.persistence.model;

public class TenantsPk  implements ITenantsPK{

	private static final long serialVersionUID = 1L;

	private Integer idtenants;
	
	public Integer getTenantId() {
		return idtenants;
	}

	public void setTenantId(Integer tenantId) {
		this.idtenants = tenantId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idtenants == null) ? 0 : idtenants.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenantsPk other = (TenantsPk) obj;
		if (idtenants == null) {
			if (other.idtenants != null)
				return false;
		} else if (!idtenants.equals(other.idtenants))
			return false;
		return true;
	}
	
	 
}
