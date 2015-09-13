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
            Criteria criteria = s.createCriteria(PersonaTipoPersona.class);
            criteria.createAlias("servicioEspecialidad", "se")
                    .add(Restrictions.eq("se.idServicioEspecialidad", idse));
                    
        return criteria.list();
            
    }

    @Override
    public boolean RegistrraTipop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
