package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;

import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
public interface ProfesoresDAO {
    public List<Profesores> GetAll();

    public Optional<Profesores> findByNoEconomico(String noEconomico);
}
