/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Usuario;
import entidades.UsuarioRol;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceUsuarioRol {
    public List<UsuarioRol> listar();
    public List<UsuarioRol> listarUsuarioRol(UsuarioRol ur);
    public UsuarioRol listarUsuarioRolU(Usuario u);
    public boolean registrarUsuarioRol(UsuarioRol ur);
    public boolean editarUsuarioRol(UsuarioRol ur);
    public boolean eliminarUsuarioRol(UsuarioRol ur);
}
