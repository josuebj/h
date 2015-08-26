/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Ubigeo;
import interfaces.InterfaceUbigeo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class UbigeoDao implements InterfaceUbigeo{

    @Override
    public List<Ubigeo> listarDepartamento() {
    //List<Ubigeo> lista = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        //try{
            s.beginTransaction();
            /*     
            String sql="from Ubigeo u where u.codProvincia=:codp";
  
            Query query=s.createQuery(sql);
            query.setParameter("codp","00" );
            lista=query.list();
            */
            Criteria criteria = s.createCriteria(Ubigeo.class);
            
            criteria.add(Restrictions.eq("codProvincia","00"));
            
            
      /*  }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
            
        }finally{
          s.close();
        }
        */
            
        return criteria.list();
    }

    @Override
    public List<Ubigeo> listarProvincia(String d) {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            /*       
            String sql="from Ubigeo u where u.codDistrito=:coddis and u.codDepartamento=:coddep and u.codProvincia<>:codpro";
  
            org.hibernate.Query query=s.createQuery(sql);
            query.setParameter("coddep",d);
            query.setParameter("coddis","00" );
            query.setParameter("codpro","00" );
            
            listap=query.list();
            */
            Criteria criteria = s.createCriteria(Ubigeo.class);
            
            criteria.add(Restrictions.eq("codDepartamento",d))
                    .add(Restrictions.eq("codDistrito", "00"))
                    .add(Restrictions.ne("codProvincia", "00"));
                    
            
            
        return criteria.list();
    }

    @Override
    public List<Ubigeo> listarDistrito(String d, String p) {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(Ubigeo.class);
            criteria.add(Restrictions.eq("codDepartamento",d))
                    .add(Restrictions.eq("codProvincia", p))
                    .add(Restrictions.ne("codDistrito","00"));
        return criteria.list();
    }
    
}
