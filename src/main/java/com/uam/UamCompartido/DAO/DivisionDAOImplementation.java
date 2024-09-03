package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Division;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author diego
 */
@Repository
public class DivisionDAOImplementation implements DivisionDAO {
    @Override
    public List<Division> GetAll() {
        return List.of();
    }
}
