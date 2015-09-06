/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.UnidadMilitarDao;
import entidades.UnidadMilitar;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Berti
 */
@ManagedBean
@RequestScoped
public class UnidadMilitarBeans {
    private List<SelectItem> unidadmilitar;
    /**
     * Creates a new instance of UnidadMilitarBeans
     */
    public UnidadMilitarBeans() {
    }
    public List<SelectItem> listarServicio(){
        unidadmilitar = new ArrayList<SelectItem>();
        UnidadMilitarDao umdao= new UnidadMilitarDao();
        List<UnidadMilitar> listse = umdao.UnidadMilitar();
        unidadmilitar.clear();      
        for(UnidadMilitar unidadm:listse){
            SelectItem selectItem = new SelectItem(unidadm.getIdUnidadMilitar(),unidadm.getSiglas());
            unidadmilitar.add(selectItem);         
        }       
        return unidadmilitar; 
    }
}
