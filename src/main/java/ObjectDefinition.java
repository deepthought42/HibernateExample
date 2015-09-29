import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Defines objects that are available to the system for learning against
 * 
 * @author Brandon Kindred
 *
 */
@Entity
@Table( name = "ObjectDefinition" )
public class ObjectDefinition {

	public ObjectDefinition(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public ObjectDefinition(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public ObjectDefinition(){}

	public int getId() {
		return id;
	}
	
	void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return "ObjectDefinition: "+ this.id + ", " + this.type + ", " + this.name;

	}
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "object_type")
	private String type;
	
	@Column(name = "object_name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="object1", cascade=CascadeType.ALL)
	private Set<ObjectDefinitionAssociation> object_associations = new HashSet<ObjectDefinitionAssociation>(0);

	public Set getObjectAssociations() {
		return object_associations;
	}
}
