package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;

import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
public interface ProfesoresDAO {
    public List<Profesores> GetAll();

    public Profesores findByNoEconomico(String noEconomico);

    public Optional<Profesores> findByEmail(String email);

    public Profesores save(Profesores profesor);
}
