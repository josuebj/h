/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.PersonaTipoPersonaDao;
import entidades.PersonaTipoPersona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Berti
 */
@ManagedBean
@ViewScoped
public class PersonaTipoPersonaBeans {

    private PersonaTipoPersona personatipopersona;
    private int idse;
    private List<SelectItem> medico;
   
    /**
     * Creates a new instance of PersonaTipoPersonaBeans
     */
    public PersonaTipoPersonaBeans() {
    }
    
     public List<SelectItem> listarMedico(){
        medico = new ArrayList<SelectItem>();
        PersonaTipoPersonaDao ptpdao= new PersonaTipoPersonaDao();
        List<PersonaTipoPersona> listptp = ptpdao.Medico(idse);       
        medico.clear();      
        for(PersonaTipoPersona ptp:listptp){
            SelectItem selectItem = new SelectItem(ptp.getPersona().getIdPersona(),ptp.getPersona().getNombres());
            medico.add(selectItem);    
        }       
        return medico;      
    }

    public int getIdse() {
        return idse;
    }

    public void setIdse(int idse) {
        this.idse = idse;
    }
     
}
