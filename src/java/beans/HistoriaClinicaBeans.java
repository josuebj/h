/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import daos.HistoriaClinicaDao;
import entidades.Admision;
import entidades.HistoriaClinica;
import entidades.Persona;
import entidades.Usuario;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Berti
 */
@ManagedBean
@ViewScoped
public class HistoriaClinicaBeans{
    
    private HistoriaClinica historiaclinica;
    
    
    private int idhc;
    private String ok;
    private Persona persona;
    private Usuario usuario;
    private String idpersona;
    private String idse;
        
    private List<HistoriaClinica> hc;
    private List<HistoriaClinica> hcs;
    
    
    
    
    /**
     * Creates a new instance of HistoriaClinicaBeans
     */
     
    public HistoriaClinicaBeans() {
        historiaclinica = new HistoriaClinica();
        
    }
    
    public String registrarHC(){
        UIComponent component = UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
        idpersona = (String) component.getAttributes().get("idpersona");
        persona.setIdPersona(Integer.parseInt(idpersona));
        idse = (String) component.getAttributes().get("idse");
        usuario.setIdUsuario(Integer.parseInt(idse));
        
        historiaclinica.setPersona(persona);
        historiaclinica.setUsuario(usuario);
        HistoriaClinicaDao hcdao= new HistoriaClinicaDao();
        
        hcdao.registrarHC(historiaclinica);
        historiaclinica = new HistoriaClinica();
        
        return "Menu.xhtml";
        
    }
    
    public List<HistoriaClinica> listarHC(){
        hc = new ArrayList<HistoriaClinica>();
        HistoriaClinicaDao hcdao=new HistoriaClinicaDao();
        
        hc = hcdao.listarHC();
        
        return hc;
    }
    public List<HistoriaClinica> listarHCS(int id){
        hcs = new ArrayList<HistoriaClinica>();
        HistoriaClinicaDao hcsdao=new HistoriaClinicaDao();
        
        hcs = hcsdao.listarHCS(id);
        return hcs;
    }

    public int getIdhc() {
        return idhc;
    }

    public void setIdhc(int idhc) {
        this.idhc = idhc;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public HistoriaClinica getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(HistoriaClinica historiaclinica) {
        this.historiaclinica = historiaclinica;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdse() {
        return idse;
    }

    public void setIdse(String idse) {
        this.idse = idse;
    }

    

   


      
    
    
    
}
