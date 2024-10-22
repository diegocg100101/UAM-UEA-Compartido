package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Grupos;

import java.util.List;

public interface GruposDAO {

    public void GrupoAdd();

    public Grupos GrupoGetByClave();

    public List<Grupos> GrupoGetAll();

    public void GrupoDelete();

    public void GrupoUpdate();

}



