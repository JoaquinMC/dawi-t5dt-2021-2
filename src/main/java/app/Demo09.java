package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Usuario;

public class Demo09 {

	
public static void main(String[] args) {
	
	//Similar a DaoFactory
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	
	//Similar a a crear el obj DAO
	EntityManager em = fabrica.createEntityManager();
	
	// proceso ->validar usando usuario y clave : login ------------------- CON PROCEDIMIENTO ALMACENADO!!!
	
	// indica la calse de consulta que le daremos a la base de datos  
	String sql =" call usp_validaAcceso(?,?); "; // consejo no uses llaves 
			
	// prepara la consulta para ser ejecutada
	Query query = em.createNativeQuery(sql, Usuario.class);
	query.setParameter(1,"U001@gmail.com");
	query.setParameter(2,"10001");
	
	Usuario u =  (Usuario) query.getSingleResult();
	 
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
