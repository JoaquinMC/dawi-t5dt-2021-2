package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> metodo que devuelve toda la informacion de una clase 
		Usuario u = em.find(Usuario.class, 121);// busca en base a la llave primaria  en este caso 121
		
		em.close();
		
		if(u==null) //si la variable tipo u de clase usuario es null significa que no lo encontro 
		{
			System.out.println("Usuario no existe");
		}
		else 
		{
			System.out.println("Usuario existe");
		}
		
	}
	
}
