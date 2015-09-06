/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.GradoInstruccion;
import interfaces.InterfaceGradoInstruccion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class GradoInstruccionDao implements InterfaceGradoInstruccion{

    @Override
    public List<GradoInstruccion> TipoPersonal() {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(GradoInstruccion.class);
            criteria.add(Restrictions.eq("rangoMilitar","00"));           
        return criteria.list();
    }

    @Override
    public List<GradoInstruccion> RangoMilitar(String tp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(GradoInstruccion.class);
            criteria.add(Restrictions.eq("tipoPersonal",tp))
                    .add(Restrictions.ne("rangoMilitar","00"));           
        return criteria.list();
    }
    
    }

