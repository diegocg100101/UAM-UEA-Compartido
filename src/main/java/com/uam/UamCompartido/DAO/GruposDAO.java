package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;

import java.util.List;

/**
 * @author diego
 */
public interface GruposDAO {
    public void Save(Grupos grupo);

    public void Update(Grupos grupo);

    public void Delete(Grupos grupo);

    public List<Grupos> GetAll();
}
