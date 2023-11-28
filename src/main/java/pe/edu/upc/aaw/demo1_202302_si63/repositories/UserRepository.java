package pe.edu.upc.aaw.demo1_202302_si63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
	List<Users> findById(long id);

	//BUSCAR POR NOMBRE
	@Query("select count(u.username) from Users u where u.username =:username")
	public int buscarUsername(@Param("username") String nombre);
	
	
	//INSERTAR ROLES
	@Transactional
	@Modifying
	@Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
	public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

	@Transactional
	@Modifying
	@Query(value= "UPDATE users\n" +
			"SET username=:p1, password=:p2, enabled=:p3 " +
			"\n" +
			"WHERE id = :id",nativeQuery = true)
	public void actualizarUsuario(long id, String p1, String p2, Boolean p3);

}