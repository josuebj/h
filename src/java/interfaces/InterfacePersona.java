/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Persona;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfacePersona {
    public List<Persona> listarPersona();
    public Persona Buscar(Persona p);
    public boolean registrarPersona(Persona p);
    public boolean editarPersona(Persona p);
    public boolean eliminarPersona(Persona p);
}
