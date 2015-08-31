/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Persona;


import interfaces.InterfacePersona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class PersonaDao implements InterfacePersona{

    @Override
    public List<Persona> listarPersona() {
        List<Persona> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            list = s.createCriteria(Persona.class).list();
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
    public Persona Buscar(Persona p) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            String sql="from Persona p where p.dni=:ndoc or p.numeroAdministrativo=:ndoc";
            org.hibernate.Query query = s.createQuery(sql);
            
            query.setParameter("ndoc", p.getNumeroAdministrativo());
                   
        return (Persona) query.uniqueResult();
    }
    

    @Override
    public boolean registrarPersona(Persona p) {
        boolean b= false;
        Session s= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
  
            s.save(p);
            
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
    public boolean editarPersona(Persona p) {
        boolean b=false;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.update(p);
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
    public boolean eliminarPersona(Persona p) {
        boolean b=false;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.delete(p);
            s.getTransaction().commit();
            b=true;
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            
        }
        return b;
    }

    

    

    
    
}
