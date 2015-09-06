/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.ServicioEspecialidad;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceServicioEspecialidad {
    public List<ServicioEspecialidad> Servicio();
    public List<ServicioEspecialidad> Especialidad(int cods);
}
