package pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces;


import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    public void insert(Users datosUser);
    public List<Users> list();
    public void delete(long IDUser);
    public Users listarId(Long id);
    public void actualizarUsers(long id, String p1, String p2, Boolean p3);
    public List<Users> findById(long id);



}
