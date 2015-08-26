/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.ExamenFisico;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceTriaje {
    
    public List<ExamenFisico> listarTriaje();
    public List<ExamenFisico> listarTriaje(ExamenFisico ef);
    public boolean registrarTriaje(ExamenFisico ef);
    public boolean editarTriaje(ExamenFisico ef);
    public boolean eliminarTriaje(ExamenFisico ef);
}
