package pe.edu.upc.aaw.demo1_202302_si63.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.RoleDTO;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Role;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService tR;

    @PostMapping
    public void registrar(@RequestBody RoleDTO dto){
        ModelMapper m = new ModelMapper();
        Role d = m.map(dto, Role.class);
        tR.insert(d);
    }

    @GetMapping
    public List<RoleDTO> listar(){
        return tR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Long id){
        tR.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO dto){
        ModelMapper m=new ModelMapper();
        Role d=m.map(dto, Role.class);
        tR.insert(d);
    }
    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") long  id) {
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(tR.listarId(id),RoleDTO.class);
        return dto;
    }
}
