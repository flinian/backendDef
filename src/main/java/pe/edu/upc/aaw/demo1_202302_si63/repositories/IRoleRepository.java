package pe.edu.upc.aaw.demo1_202302_si63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
