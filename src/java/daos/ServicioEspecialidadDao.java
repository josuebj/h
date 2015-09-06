/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.ServicioEspecialidad;
import interfaces.InterfaceServicioEspecialidad;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class ServicioEspecialidadDao implements InterfaceServicioEspecialidad{

    @Override
    public List<ServicioEspecialidad> Servicio() {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();          
            Criteria criteria = s.createCriteria(ServicioEspecialidad.class);        
            criteria.add(Restrictions.eq("codEspecialidad",0));
        return criteria.list();
    }

    @Override
    public List<ServicioEspecialidad> Especialidad(int cods) {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();          
            Criteria criteria = s.createCriteria(ServicioEspecialidad.class);        
            criteria.add(Restrictions.eq("codServicio", cods))
                    .add(Restrictions.ne("codEspecialidad",0));

        return criteria.list();
    }
    
}
