package com.alura.forohub.domain.entity;

import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(unique = true)
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String email;

    public Usuario(CrearUsuarioRequest datos){
        this.nombreUsuario = datos.nombreUsuario();
        this.contrasena = datos.contrasena();
        this.nombre = datos.nombre();
        this.email = datos.email();
    }

    public DatosUsuario getDTO(){
        return new DatosUsuario(usuarioId, nombreUsuario, email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
