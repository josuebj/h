/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.HistoriaClinica;
import interfaces.InterfaceHistoriaClinica;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class HistoriaClinicaDao implements InterfaceHistoriaClinica{

    @Override
    public List<HistoriaClinica> listarHitoriaClinica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoriaClinica BuscarHistoriaClinica(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarHistoriaClinica(HistoriaClinica hc) {
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
            s.close();
        }
        return b;
    }

    @Override
    public boolean editarHistoriaClinica(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarHistoriaClinica(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
