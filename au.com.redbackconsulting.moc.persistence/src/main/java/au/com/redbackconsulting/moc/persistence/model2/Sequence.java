package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sequence
 *
 */
@Entity

public class Sequence implements Serializable {

	
	private String label;   
	@Id
	private Long id;
	private static final long serialVersionUID = 1L;

	public Sequence() {
		super();
	}   
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
