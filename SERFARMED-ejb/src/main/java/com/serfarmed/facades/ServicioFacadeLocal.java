/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serfarmed.facades;

import com.serfarmed.entities.Servicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Raul
 */
@Local
public interface ServicioFacadeLocal {

  void create(Servicio producto);

  void edit(Servicio producto);

  void remove(Servicio producto);

  Servicio find(Object id);

  List<Servicio> findAll();

  List<Servicio> findRange(int[] range);

  int count();
  
}
