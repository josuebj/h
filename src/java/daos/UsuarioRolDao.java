/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Persona;
import entidades.Usuario;
import entidades.UsuarioRol;
import interfaces.InterfaceUsuarioRol;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class UsuarioRolDao implements InterfaceUsuarioRol{

    @Override
    public List<UsuarioRol> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioRol listarUsuarioRolU(Usuario u) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            String sql="from UsuarioRol ur where ur.usuario=:idu";
            org.hibernate.Query query = s.createQuery(sql);
            
            query.setParameter("idu",u.getIdUsuario() );
                   
        return (UsuarioRol) query.uniqueResult();
    }

    @Override
    public boolean registrarUsuarioRol(UsuarioRol ur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarUsuarioRol(UsuarioRol ur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuarioRol(UsuarioRol ur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioRol> listarUsuarioRol(UsuarioRol ur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
