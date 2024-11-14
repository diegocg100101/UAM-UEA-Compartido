package com.uam.UamCompartido.Editor;

import com.uam.UamCompartido.DAO.ProfesoresDAOImplementation;
import com.uam.UamCompartido.JPA.*;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfesoresEditor extends PropertyEditorSupport {

    @Autowired
    private ProfesoresDAOImplementation profesoresDAO;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // El texto recibido es el 'noEconomico' del Profesor, que es un String
        try {
            // Intentamos obtener el Profesor usando su 'noEconomico'
            Profesores profesor = profesoresDAO.findByNoEconomico(text);
            if (profesor == null) {
                throw new IllegalArgumentException("Profesor con noEconomico '" + text + "' no encontrado");
            }
            setValue(profesor);  // Establecemos el Profesor como el valor del PropertyEditor
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al convertir el valor a Profesor: " + e.getMessage(), e);
        }
    }
}
