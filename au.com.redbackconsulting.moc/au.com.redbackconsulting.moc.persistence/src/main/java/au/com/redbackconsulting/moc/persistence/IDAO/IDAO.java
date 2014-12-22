package au.com.redbackconsulting.moc.persistence.IDAO;
 

public interface  IDAO<E>     {
	
	 public  String getidFieldName();
	
    public void refresh(E object);
	
	  

}
