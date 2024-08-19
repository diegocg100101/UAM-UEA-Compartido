package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
@Repository
public class ProfesoresDAOImplementation implements ProfesoresDAO {
    @Override
    public List<Profesores> GetAll() {
        return List.of();
    }

    @Override
    public Optional<Profesores> findByNoEconomico(String noEconomico) {
        return null;
    }
}
