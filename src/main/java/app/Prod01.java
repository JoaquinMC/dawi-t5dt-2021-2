package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Prod01 {

public static void main(String[] args) {
		
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> registrar un nuevo Producto
		Producto p = new Producto();
		p.setId_prod("P0040");
		p.setDes_prod("Prueba 40");
		p.setIdcategoria(1);
		p.setEst_prod(1);
		p.setStk_prod(100);
		p.setPre_prod(0.99);
		p.setIdprovedor(1);
		
		//invocamos la transaccion  con begin que significa empezar
		em.getTransaction().begin();
		
		// ahora usamos el metodo persist que significa grabar
		em.persist(p); // <--- eso quiere decir que vamos a registrar le damos la variable que contiene la info 
		
		//Invocamos un transcaccion nuevamanete para confirmar la transaccion usando comit 
		em.getTransaction().commit(); 
		
		//cerramos la conexion 
		em.close();
		
	}

	
}
