package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
		
public static void main(String[] args) {
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso ->validar usando usuario y clave : login -------------------
		
		// indica la calse de consulta que le daremos a la base de datos 
		String sql ="SELECT u FROM Usuario u where u.usuario = :xusr and u.clave =:xcla ";
				
		// prepara la consulta para ser ejecutada
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		query.setParameter("xusr","U001@gmail.com");
		query.setParameter("xcla","10001");
		
		Usuario u = query.getSingleResult();
		 
		em.close();
		
		if(u==null) //si la variable tipo u de clase usuario es null significa que no lo encontro 
		{
			System.out.println("Usuario no existe, o datos incorrectos");
		}
		else 
		{
			System.out.println("Bienvenido " + u.getNombre());
		}
		
	}
}
