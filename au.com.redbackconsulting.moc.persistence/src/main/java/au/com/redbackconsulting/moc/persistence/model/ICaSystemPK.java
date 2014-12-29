package au.com.redbackconsulting.moc.persistence.model;

public interface ICaSystemPK extends  IPkModel {
	
	public Integer getTenantId() ;
	public void setTenantId(Integer tenantId);
	public String getSystId() ;
	public void setSystId(String systId);

}
