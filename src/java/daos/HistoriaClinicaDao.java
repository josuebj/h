/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.HistoriaClinica;
import interfaces.InterfaceHistoriaClinica;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class HistoriaClinicaDao implements InterfaceHistoriaClinica{

    @Override
    public List<HistoriaClinica> listarHC() {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(HistoriaClinica.class);
            return criteria.list();
    }
    
    @Override
    public List<HistoriaClinica> listarHCS(int idhc){
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criterias = s.createCriteria(HistoriaClinica.class);
           String id= Integer.toString(idhc);
            criterias.add(Restrictions.eq("historiaClinica", idhc));
            return criterias.list();
    }
    


    @Override
    public HistoriaClinica BuscarHC(HistoriaClinica hc) {
        
    }

    @Override
    public boolean registrarHC(HistoriaClinica hc) {
        boolean b= false;
        Session s= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.save(hc);   
            s.getTransaction().commit();
            b=true;
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }finally{
            
        }
        return b;
    }

    @Override
    public boolean editarHC(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarHC(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
