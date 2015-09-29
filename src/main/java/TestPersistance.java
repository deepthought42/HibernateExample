import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestPersistance {
   private static SessionFactory factory; 

	public static void main(String[] args){
		// First unit of work
		 ObjectDefinition objDef1 = null;
		 ObjectDefinition objDef2 = null;
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 try{	 
			 session.beginTransaction();

			 objDef1 = new ObjectDefinition("a", "obj");
			 objDef1.setId((Integer)session.save(objDef1));

			 objDef2 = new ObjectDefinition("b", "obj");
			 objDef2.setId((Integer)session.save(objDef2));

			 System.out.println("Object1 ID :: " + objDef1.getId());

		 }catch(PersistenceException e){
			 e.printStackTrace();
			 System.out.println("coudnl't save");
		 }

		 try{
			 System.out.println("Creating association to be saved");
			 ObjectAssociationId associationId = new ObjectAssociationId(objDef1.getId(), objDef2.getId());
			 ObjectDefinitionAssociation object_association = new ObjectDefinitionAssociation();
			 object_association.setId(associationId);
			 object_association.setObject1Definition(objDef1);
			 object_association.setObject2Definition(objDef2);

			 objDef1.getObjectAssociations().add(object_association);
			 ObjectAssociationId objectAssocId = (ObjectAssociationId)session.save(object_association);
			 System.out.println("OBJECT ASSOCIATION ID :: "+ objectAssocId.getObject1Id() + " : "+objectAssocId.getObject2Id());

		 }catch(PersistenceException e){
			 e.printStackTrace();
		 }		 
		 session.flush();
		 session.close();
	}
}
