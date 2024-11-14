package com.uam.UamCompartido.Editor;
import com.uam.UamCompartido.JPA.*;
import java.beans.PropertyEditorSupport;

public class HorarioEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Supongamos que el formato del String es "id_horario,hora_inicio,hora_termino,dias"
        String[] parts = text.split(",");
        if (parts.length == 4) {
            try {
                int id_horario = Integer.parseInt(parts[0]);
                String hora_inicio = parts[1];
                String hora_termino = parts[2];
                String dias = parts[3];

                Horario horario = new Horario();
                horario.setId_horario(id_horario);
                horario.setHora_inicio(hora_inicio);
                horario.setHora_termino(hora_termino);
                horario.setDias(dias);

                setValue(horario);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de id_horario inválido", e);
            }
        } else {
            throw new IllegalArgumentException("Formato de Horario inválido");
        }
    }
}
