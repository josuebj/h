/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.PersonaTipoPersona;
import interfaces.InterfacePersonaTipoPersona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class PersonaTipoPersonaDao implements InterfacePersonaTipoPersona{

    @Override
    public List<PersonaTipoPersona> Medico(int idse) {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();

        List<PersonaTipoPersona> listap= new ArrayList<>();
            String sql="from PersonaTipoPersona p where p.servicioEspecialidad=:id";
            org.hibernate.Query query=s.createQuery(sql);          
            query.setParameter("id",idse);           
            listap=query.list();
            return listap;
            
    }

    @Override
    public boolean RegistrraTipop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
