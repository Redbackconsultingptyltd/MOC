package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

public interface ICaSystems extends IDBEntity {
	
	public String getSystId() ;

	public void setSystId(String systId) ;
	public String getSystDesc() ;
	public void setSystDesc(String systDesc);
	public Collection<HrObjects> getHrObjects() ;
	public void setHrObjects(Collection<HrObjects> param) ;
	
	public Integer getTenantId() ;
	public void setTenantId(Integer tenantId) ;
}
