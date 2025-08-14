package com.alura.forohub.domain.entity;

import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(unique = true)
    private String nombreUsuario;
    private String contrasena;
    private String email;

    public Usuario(CrearUsuarioRequest datos){
        this.nombreUsuario = datos.nombreUsuario();
        this.contrasena = datos.contrasena();
        this.email = datos.email();
    }

    public DatosUsuario getDTO(){
        return new DatosUsuario(usuarioId, nombreUsuario, email);
    }

}
