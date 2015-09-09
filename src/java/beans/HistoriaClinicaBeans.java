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



import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


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
    private int idpersona;
    private int idse;
    private String idp;    
    private List<HistoriaClinica> hc;
    private List<HistoriaClinica> hcs;
    
    
    
    
    /**
     * Creates a new instance of HistoriaClinicaBeans
     */
     
    public HistoriaClinicaBeans() {
        historiaclinica = new HistoriaClinica();
        persona= new Persona();
        usuario= new Usuario();
    }
    
    public String registrarHC(){
        String idp = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idpersona");
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idse");
        
        persona.setIdPersona(Integer.parseInt(idp));
        usuario.setIdUsuario(Integer.parseInt(ids));
        HistoriaClinicaDao hcdao=new HistoriaClinicaDao();
        int ne = hcdao.NumEpidosio(Integer.parseInt(idp));
        ne=ne+1;
        historiaclinica.setPersona(persona);
        historiaclinica.setUsuario(usuario);
        historiaclinica.setNumEpisodio(ne);
            
        hcdao.registrarHC(historiaclinica);
        
        
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

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdse() {
        return idse;
    }

    public void setIdse(int idse) {
        this.idse = idse;
    }

    

    

   


      
    
    
    
}
