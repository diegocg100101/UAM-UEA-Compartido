package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author diego
 */
@Entity
public class Profesores implements UserDetails {

    @Id
    @Column(name = "noeconomico")
    private String NoEeconomico;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;

    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "idunidad")
    private Unidad Unidad;

    @ManyToOne
    @JoinColumn(name = "iddivision")
    private Division division;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;




    public Profesores(){
        this.Unidad = new Unidad();
        this.division = new Division();
    }

    public String getNoEeconomico() {
        return NoEeconomico;
    }

    public void setNoEeconomico(String noEeconomico) {
        NoEeconomico = noEeconomico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public com.uam.UamCompartido.JPA.Unidad getUnidad() {
        return Unidad;
    }

    public void setUnidad(com.uam.UamCompartido.JPA.Unidad unidad) {
        Unidad = unidad;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
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
