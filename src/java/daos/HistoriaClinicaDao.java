/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.HistoriaClinica;
import factory.ConexionBD;
import factory.FactoryConnectionDB;
import interfaces.InterfaceHistoriaClinica;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ParseConversionEvent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class HistoriaClinicaDao implements InterfaceHistoriaClinica{
    ConexionBD conn;
    @Override
    public List<HistoriaClinica> listarHC() {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            
            List<HistoriaClinica> listap= new ArrayList<>();
            String sql="from HistoriaClinica hc where hc.historiaClinica=:idp";
  
            org.hibernate.Query query=s.createQuery(sql);
            
            query.setParameter("idp",new Integer(1) );
            
            
            listap=query.list();
            return listap;
    }
    
    @Override
    public List<HistoriaClinica> listarHCS(int idhc){
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criterias = s.createCriteria(HistoriaClinica.class);
           String id= Integer.toString(idhc);
            criterias.add(Restrictions.eq("Persona.persona", idhc));
            return criterias.list();
    }
    
    @Override
    public HistoriaClinica BuscarHC(HistoriaClinica hc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean registrarHC2(HistoriaClinica hc) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean b= false;
        try {
//            System.out.println(departamentp.getId()+", "+departamentp.getProv()+", "+departamentp.getDir()+", "+departamentp.getRuc()+", "+departamentp.getTel()+", "+departamentp.getEst());
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Historia_Clinica(iddepartamento, departamento, Centro_Costos, Status) VALUES(").append("NULL");
                sql.append(", '").append(departamento.getDpto());
                sql.append("', ").append(departamento.getCostos());
                sql.append(", ").append(departamento.getStatus()).append(")");
                //String sql1 = "INSERT INTO Proveedor(iddepartamentp)VALUES(10)";
                this.conn.execute(sql.toString());
                b = true;
        } catch (Exception e) {
            this.conn.close();
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
