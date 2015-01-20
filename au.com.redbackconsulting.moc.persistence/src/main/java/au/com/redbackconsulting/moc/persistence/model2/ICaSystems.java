package au.com.redbackconsulting.moc.persistence.model2;

import java.util.Collection;

public interface ICaSystems extends IDBEntity {
	
	public String getSystId() ;

	public void setSystId(String systId) ;
	public String getSystDesc() ;
	public void setSystDesc(String systDesc);
	 	
	public Integer getTenantId() ;
	public void setTenantId(Integer tenantId) ;
}
