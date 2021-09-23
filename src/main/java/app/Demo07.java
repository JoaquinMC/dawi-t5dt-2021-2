package app;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Usuario;

public class Demo07 {
	 
public static void main(String[] args) {
		
		//Similar a DaoFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Similar a a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		//consultar datos del usuario
		
		//em.createquery("sentencia de consulta JPQL", claseDeResultado)
		System.out.println("--- Lisatado de los usuarios ---");
		List<Usuario> lstUsuarios =em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();	
		System.out.println("Cantidad de usuarios : "+lstUsuarios.size());
		for (Usuario u : lstUsuarios) {
			
			System.out.println(u);
		}  
		System.out.println("-------------------------------");
		
		
		
		System.out.println("--- Listado de los Usuarios de tipo 2 ---");
		
		// indica la calse de consulta que le daremos a la base de datos
		String sql ="SELECT u FROM Usuario u where u.tipo = :xtipo";
		
		// prepara la consulta para ser ejecutada
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		
		// indica los parametros que va a seguir
		query.setParameter("xtipo", 2);
		
		//ejecuta la consulta y convierte el resultado en una variable de tipo lista
		List<Usuario> lstUsuarios2= query.getResultList();                                    		
		
		
		// Muestra los resultados
		System.out.println("Cantidad de usuarios : " + lstUsuarios2.size());
		
		for (Usuario u : lstUsuarios2) 
		{
			
			System.out.println(u);
		}
		System.out.println("------------------------------------------------");
		
		em.close();
		
	
	}
	
















}
