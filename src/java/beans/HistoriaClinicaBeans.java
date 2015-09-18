/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;



import daos.AdmisionDao;
import daos.HistoriaClinicaDao;
import entidades.Admision;
import entidades.GradoInstruccion;
import entidades.HistoriaClinica;
import entidades.Persona;
import entidades.Ubigeo;
import entidades.UnidadMilitar;
import entidades.Usuario;



import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;




/**
 *
 * @author Berti
 */
@ManagedBean
@SessionScoped
public class HistoriaClinicaBeans{
    
    private HistoriaClinica historiaclinica;   
    private int idhc;
    private String ok;
    private Persona persona;
    private Usuario usuario;
    private Admision admision;
    private Ubigeo ubigeo;
    private UnidadMilitar unidadmilitar;
    private GradoInstruccion gradoinstruccion;
    
    
       
    private List<HistoriaClinica> hc;
    private List<HistoriaClinica> hcs;
    
    private String idp;
    private String ids;
    
    private boolean rhc;
    
    private int personal;
    private int umilitar;
    private int procedencia;
    private int medico;
    
    
    /**
     * Creates a new instance of HistoriaClinicaBeans
     */
     
    public HistoriaClinicaBeans() {
        historiaclinica = new HistoriaClinica();
        admision = new Admision();
        persona= new Persona();
        usuario= new Usuario();
        gradoinstruccion= new GradoInstruccion();
        ubigeo = new Ubigeo();
        unidadmilitar = new UnidadMilitar();
        
    }
    

    
    public String registrarHC(){
        idp = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idper");
        ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("iduser");
        
        
        persona.setIdPersona(Integer.parseInt(idp));
        usuario.setIdUsuario(Integer.parseInt(ids));
        
        HistoriaClinicaDao hcdao=new HistoriaClinicaDao();
        int ne = hcdao.NumEpidosio(Integer.parseInt(idp));
        ne=ne+1;
        historiaclinica.setPersona(persona);
        historiaclinica.setUsuario(usuario);
        historiaclinica.setNumEpisodio(ne);
        
        rhc = hcdao.registrarHC(historiaclinica);
        
       if(rhc==true){
       int idhc=hcdao.UltimoHC(Integer.parseInt(idp));
        historiaclinica.setIdHistoriaClinica(idhc);
        gradoinstruccion.setIdGradoInstruccion(personal);
        unidadmilitar.setIdUnidadMilitar(umilitar);
        ubigeo.setIdUbigeo(procedencia);
        persona.setIdPersona(medico);
        
        admision.setHistoriaClinica(historiaclinica);
        admision.setGradoInstruccion(gradoinstruccion);
        admision.setUnidadMilitar(unidadmilitar);
        admision.setUbigeo(ubigeo);
        admision.setPersona(persona);
        admision.setUsuario(usuario);
        
        
        AdmisionDao admisiondao= new AdmisionDao();
        boolean a= admisiondao.registrarAdmision(admision);       
        
        if(a=true){
        return "Inicio.xhtml";
        }
        return "Logueo.xhtml";
       }
        return "Logueo.xhtml";
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



    public Admision getAdmision() {
        return admision;
    }

    public void setAdmision(Admision admision) {
        this.admision = admision;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public boolean isRhc() {
        return rhc;
    }

    public void setRhc(boolean rhc) {
        this.rhc = rhc;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getUmilitar() {
        return umilitar;
    }

    public void setUmilitar(int umilitar) {
        this.umilitar = umilitar;
    }

    public int getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(int procedencia) {
        this.procedencia = procedencia;
    }

    public int getMedico() {
        return medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }

    

    

    

   


      
    
    
    
}
