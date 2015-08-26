/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceUsuario {
    public Usuario validarUser(Usuario u);
    
    public List<Usuario> listarUsuario();
    public List<Usuario> listarUsuario(Usuario u);
    public boolean registrarUsuario(Usuario u);
    public boolean editarUsuario(Usuario u);
    public boolean eliminarUsuario(Usuario u);
}
