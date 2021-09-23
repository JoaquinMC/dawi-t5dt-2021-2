package app;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;


public class Demo05 {

public static void main(String[] args) {
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> metodo que devuelve toda la informacion de una clase segun los parametros dados
		Usuario u = em.find(Usuario.class, 123);
		
		if(u==null) //si la variable tipo u de clase usuario es null significa que no lo encontro 
		{
			System.out.println("Usuario no existe");
		}
		else 
		{
			System.out.println("Usuario existe!!!\n"+ u);
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			System.out.println("Usuario eliminado");
		}
		
		em.close(); // cerramos conexion
	}
	
}