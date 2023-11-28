package pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces;

import pe.edu.upc.aaw.demo1_202302_si63.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role tiposUsuario);
    public List<Role> list();
    public Role listarId(long id);
    public void delete(Long id);
}
