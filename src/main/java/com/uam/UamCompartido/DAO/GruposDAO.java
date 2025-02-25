package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;

import java.util.List;

/**
 * @author diego
 */
public interface GruposDAO {
    public void Save(Grupos grupo);

    public void Update(String clave);

    public void Delete(String clave);

    public List<Grupos> GetAll();

    public Grupos GetByClave(String clave);
}
