package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Horario;

import java.util.List;

public interface HorarioDAO {
    public List<Horario> GetAllHorario();

    public Horario GetHorarioById(Integer id);
}
