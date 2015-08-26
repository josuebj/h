/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Admision;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceAdmision {
    
    public List<Admision> listarAdmision();
    public List<Admision> listarAdmision(Admision a);
    public boolean registrarAdmision(Admision a);
    public boolean editarAdmision(Admision a);
    public boolean eliminarAdmision(Admision a);
    
}
