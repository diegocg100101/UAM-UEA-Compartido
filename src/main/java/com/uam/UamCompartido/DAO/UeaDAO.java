/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.UEA;
import java.util.List;

/**
 *
 * @author LGMX
 */
public interface UeaDAO {

    public void Add(UEA uea);

    public List<UEA> GetAll();

    public void Delete(String clave);

    public void Edit(UEA uea);

    public UEA GetByClave(String clave);

    public List<UEA> GetAllByClave(String clave);

    List<UEA> GetByNombre(String nombre);
}
