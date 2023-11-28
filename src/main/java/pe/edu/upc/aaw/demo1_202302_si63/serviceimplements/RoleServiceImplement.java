package pe.edu.upc.aaw.demo1_202302_si63.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Role;
import pe.edu.upc.aaw.demo1_202302_si63.repositories.IRoleRepository;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository tR;

    @Override
    public void insert(Role role) {
        tR.save(role);
    }

    @Override
    public List<Role> list() {
        return tR.findAll();
    }

    @Override
    public Role listarId(long id) {
        return tR.findById(id).orElse(new Role());
    }

    @Override
    public void delete(Long id) {
        tR.deleteById(id);
    }


}
