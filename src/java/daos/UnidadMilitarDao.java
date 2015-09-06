/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.UnidadMilitar;
import interfaces.InterfaceUnidadMilitar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Berti
 */
public class UnidadMilitarDao implements InterfaceUnidadMilitar{

    @Override
    public List<entidades.UnidadMilitar> UnidadMilitar() {
        Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(UnidadMilitar.class);          
        return criteria.list();
    }
    
}
