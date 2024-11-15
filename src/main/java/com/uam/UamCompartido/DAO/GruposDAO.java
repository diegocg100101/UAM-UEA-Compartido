package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;

import java.util.List;

public interface GruposDAO {

    public Grupos save(Grupos grupos);

    public Grupos GrupoGetByClave();

    public List<Grupos> GrupoGetAll();

    public void GrupoDelete();

    public void GrupoUpdate();

}



