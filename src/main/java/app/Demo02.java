package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
		
	public static void main(String[] args) {
		
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> actualiza un usuario
		Usuario u = new Usuario();
		u.setCodigo(6);
		u.setNombre("Levi");
		u.setApellido("Ackerman");
		u.setUsuario("tatakae6@titan.pe");
		u.setClave("1234");
		u.setFnacim("2021/08/04");
		u.setTipo(1);
		u.setEstado(1);
		
		
		//invocamos la transaccion  con begin que significa empezar
		em.getTransaction().begin();
		
		// ahora usamos el metodo merge que significa actualizar
		em.merge(u); // <--- eso quiere decir que vamos a actualizar // en caso no encuentre el dato a actualizar el metodo creara uno
		 
		//Invocamos un transcaccion nuevamanete para confirmar la transaccion usando comit 
		em.getTransaction().commit(); 
		
		System.out.println("Usuario actualizado");
		
		//cerramos la conexion 
		em.close();
		
	}
	
}
