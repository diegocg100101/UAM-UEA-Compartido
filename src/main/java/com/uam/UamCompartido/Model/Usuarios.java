package com.uam.UamCompartido.Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @author diego
 */

@Entity
public class Usuarios implements UserDetails {

    @Id
    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Clave")
    private String clave;

    @Column(name = "Tipo")
    private String Tipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idrol")
    private Roles Rol;

    public Usuarios() {
        this.Rol = new Roles();
    }


    public com.uam.UamCompartido.Model.Roles getRol() {
        return Rol;
    }

    public void setRol(com.uam.UamCompartido.Model.Roles rol) {
        Rol = rol;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Rol.getNombre()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
