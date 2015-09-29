import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Associates 2 {@link ObjectDefinition}s with each other and represents their
 * probabilistic association with each other
 * 
 * @author Brandon Kindred
 *
 */
@Entity
@Table(name="object_definition_associations")
public class ObjectDefinitionAssociation {
	
	public ObjectDefinitionAssociation() {	}

	public ObjectDefinitionAssociation(ObjectAssociationId id, ObjectDefinition object1, ObjectDefinition object2){
		this.id = id;
		this.object1 = object1;
		this.object2 = object2;
	}
	
	public ObjectAssociationId getId(){
		return this.id;
	}
	
	public void setId(ObjectAssociationId id){
		this.id = id;
	}
	
	public ObjectDefinition getObject1Defintion() {
		return object1;
	}
	
	public void setObject1Definition(ObjectDefinition objectDefintion) {
		object1 = objectDefintion;
	}

	public ObjectDefinition getObject2Definition() {
		return object2;
	}

	public void setObject2Definition(ObjectDefinition objectDefinition2) {
		object2 = objectDefinition2;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getCount() {
		return experience_count;
	}

	public void setCount(int count) {
		this.experience_count = count;
	}

	@EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "object1_id", column = @Column(name = "object1_id", nullable = false)),
            @AttributeOverride(name = "object2_id", column = @Column(name = "object2_id", nullable = false)) })
	private ObjectAssociationId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="object1_id", nullable = false, insertable = false, updatable = false)
	private ObjectDefinition object1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="object2_id", nullable = false, insertable = false, updatable = false)
	private ObjectDefinition object2;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="experience_count")
	private int experience_count;

}
