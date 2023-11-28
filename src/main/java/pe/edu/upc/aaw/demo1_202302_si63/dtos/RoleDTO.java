package pe.edu.upc.aaw.demo1_202302_si63.dtos;

import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;

import javax.persistence.*;

public class RoleDTO {
    private Long id;
    private String rol;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
