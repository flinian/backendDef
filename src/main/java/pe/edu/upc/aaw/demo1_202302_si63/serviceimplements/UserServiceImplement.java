package pe.edu.upc.aaw.demo1_202302_si63.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;
import pe.edu.upc.aaw.demo1_202302_si63.repositories.UserRepository;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IUserService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private UserRepository iU;

    @Override
    public void insert(Users datosUser) {
        iU.save(datosUser);
    }

    @Override
    public List<Users> list() {
        return iU.findAll();
    }

    @Override
    public void delete(long IDUser) {
        iU.deleteById(IDUser);
    }

    @Override
    public Users listarId(Long id) {
        return iU.findById(id).orElse(new Users());
    }

    @Override
    public void actualizarUsers(long id, String p1, String p2, Boolean p3) {
        iU.actualizarUsuario(id, p1, p2, p3);
    }

    @Override
    public List<Users> findById(long id) {
        return iU.findById(id);
    }

}
