/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.ServicioEspecialidadDao;
import entidades.ServicioEspecialidad;
import java.io.Serializable;
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
public class ServicioEspecialidadBeans implements Serializable{

    private ServicioEspecialidad se;
    private int cods;
    private List<SelectItem> servicio;
    private List<SelectItem> especialidad;
    /**
     * Creates a new instance of ServicioEspecialidadBeans
     */
    public ServicioEspecialidadBeans() {
    }
    
    
    public List<SelectItem> listarServicio(){
        servicio = new ArrayList<SelectItem>();
        ServicioEspecialidadDao sedao= new ServicioEspecialidadDao();
        List<ServicioEspecialidad> listse = sedao.Servicio();
        servicio.clear();      
        for(ServicioEspecialidad servicioespecialidad:listse){
            SelectItem selectItem = new SelectItem(servicioespecialidad.getCodServicio(),servicioespecialidad.getNombre());
            servicio.add(selectItem);         
        }       
        return servicio; 
        
    }
    public List<SelectItem> listarEspecialidad(){
    especialidad = new ArrayList<SelectItem>();
    ServicioEspecialidadDao sedao= new ServicioEspecialidadDao();
    List<ServicioEspecialidad> listse= sedao.Especialidad(cods);
    especialidad.clear();
    for(ServicioEspecialidad servicioespecialidad:listse){
        SelectItem selectItem = new SelectItem(servicioespecialidad.getIdServicioEspecialidad(),servicioespecialidad.getNombre());
        especialidad.add(selectItem);
    }
    return especialidad;

    }

    public int getCods() {
        return cods;
    }

    public void setCods(int cods) {
        this.cods = cods;
    }

    

    
    
}
