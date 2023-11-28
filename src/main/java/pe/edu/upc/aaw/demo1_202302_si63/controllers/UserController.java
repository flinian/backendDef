package pe.edu.upc.aaw.demo1_202302_si63.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.DessertDTO;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.UserDTO;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService uR;

    @PostMapping
    public void registrar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        Users i = m.map(dto, Users.class);
        uR.insert(i);
    }

    @GetMapping
    public List<UserDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        uR.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody UserDTO dto){
        ModelMapper m=new ModelMapper();
        Users d=m.map(dto, Users.class);
        uR.insert(d);
    }

    @GetMapping("/actualizar/{id2}/{p1}/{p2}/{p3}")
    public void actualizardatos(@PathVariable("id2") Long id2, @PathVariable("p1") String p1,
                                @PathVariable("p2") String p2, @PathVariable("p3") String p3)
    {
        uR.actualizarUsers(id2,p1,p2,Boolean.parseBoolean(p3));
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uR.listarId(id),UserDTO.class);
        return dto;
    }

    //@GetMapping("/{id2}")
    //public List<UserDTO> listarporid(@PathVariable("id2") Long id){
    //    return uR.findById(id).stream().map(x->{
    //        ModelMapper m=new ModelMapper();
    //        return m.map(x, UserDTO.class);
    //    }).collect(Collectors.toList());
    //}

}
