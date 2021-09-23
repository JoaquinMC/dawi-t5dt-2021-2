package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> registrar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(123);
		u.setNombre("Eren");
		u.setApellido("Ackerman");
		u.setUsuario("eren@titan.pe");
		u.setClave("1234");
		u.setFnacim("2021/08/04");
		u.setTipo(1);
		u.setEstado(1);
		
		
		//invocamos la transaccion  con begin que significa empezar
		em.getTransaction().begin();
		
		// ahora usamos el metodo persist que significa grabar
		em.persist(u); // <--- eso quiere decir que vamos a registrar
		
		//Invocamos un transcaccion nuevamanete para confirmar la transaccion usando comit 
		em.getTransaction().commit(); 
		
		//cerramos la conexion 
		em.close();
		
	}

}
