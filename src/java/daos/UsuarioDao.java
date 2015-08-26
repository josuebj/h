/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;



import entidades.Persona;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import interfaces.InterfaceUsuario;
import util.HibernateUtil;

/**
 *
 * @author DReyna
 */
public class UsuarioDao implements InterfaceUsuario{
private Usuario usuario;
    @Override
    public Usuario validarUser(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Usuario u where u.usuario_1=:user and u.password=:pass";
        org.hibernate.Query query = session.createQuery(sql);
        
        query.setString("user", u.getUsuario_1());
        query.setString("pass", u.getPassword());
        usuario =(Usuario) query.uniqueResult();
        return usuario;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            list = s.createCriteria(Usuario.class).list();
            s.getTransaction().commit();
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
            
        }finally{
            s.close();
        }
        
        return list;
    }
        
    @Override
    public List<Usuario> listarUsuario(Usuario u) {
        List<Usuario> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            //list = s.createQuery("from Usuario where usuario=:").getNamedParamet;
            s.getTransaction();
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }finally{
            s.close();
        }
        return list;
    }

    @Override
    public boolean registrarUsuario(Usuario u) {
        boolean b= false;
        Session s= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
  
            s.save(u);
            
            s.getTransaction().commit();
            b=true;
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }finally{
            s.close();
        }
        return b;
    }

    @Override
    public boolean editarUsuario(Usuario u) {
        boolean b=false;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.update(u);
            s.getTransaction().commit();
            b=true;
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }finally{
            s.close();
        }
        return b;
    }

    @Override
    public boolean eliminarUsuario(Usuario u) {
        boolean b=false;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.delete(u);
            s.getTransaction().commit();
            b=true;
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            
        }
        return b;
      }
   
}

