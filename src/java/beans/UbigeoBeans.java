/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.UbigeoDao;
import entidades.Ubigeo;
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
public class UbigeoBeans {
    private Ubigeo u;
    private String coddep;
    private String codpro;
    private List<SelectItem> departamento;
    private List<SelectItem> provincia;
    private List<SelectItem> distrito;
   
    
    
    

    /**
     * Creates a new instance of UbigeoBeans
     */
    public UbigeoBeans() {
    }

    public Ubigeo getU() {
        return u;
    }

    public void setU(Ubigeo u) {
        this.u = u;
    }

    public String getCoddep() {
        return coddep;
    }

    public void setCoddep(String coddep) {
        this.coddep = coddep;
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public List<SelectItem> listarDepartamento(){
        departamento = new ArrayList<SelectItem>();
        UbigeoDao ubigeodao= new UbigeoDao();
        List<Ubigeo> listubigeo = ubigeodao.listarDepartamento();       
        departamento.clear();      
        for(Ubigeo ubigeo:listubigeo){
            SelectItem selectItem = new SelectItem(ubigeo.getCodDepartamento(),ubigeo.getNombre());
            departamento.add(selectItem);
            
        }       
        return departamento;      
    }
    

    
    public List<SelectItem> listarProvincia(){
        provincia = new ArrayList<SelectItem>();
        UbigeoDao ubigeodao= new UbigeoDao();
        List<Ubigeo> listubigeop = ubigeodao.listarProvincia(coddep);
        provincia.clear();   
        for(Ubigeo ubigeo:listubigeop){            
            SelectItem selectItem = new SelectItem(ubigeo.getCodProvincia(), ubigeo.getNombre());
            provincia.add(selectItem);
            
        }        
        return provincia;         
    }
    
    
    public List<SelectItem> listarDistrito(){
        distrito = new ArrayList<SelectItem>();
        UbigeoDao ubigeodao= new UbigeoDao();
        List<Ubigeo> listubigeodis = ubigeodao.listarDistrito(coddep,codpro);      
        distrito.clear();
        for(Ubigeo ubigeo:listubigeodis){
            SelectItem selectItem = new SelectItem(ubigeo.getIdUbigeo(),ubigeo.getNombre());
            distrito.add(selectItem);
        }       
        return distrito;          
    }
    
    
}
