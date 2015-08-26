/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.PersonaDao;
import entidades.Persona;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Berti
 */
@ManagedBean
@RequestScoped
public class PersonaBeans {
    private Persona persona;
    private int ndoc;
    private String nombre;
    private String apellidop;
    private String apellidom;
    
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
    private final RequestContext requestContext;

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getNdoc() {
        return ndoc;
    }

    public void setNdoc(int ndoc) {
        this.ndoc = ndoc;
    }
    
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    
    public PersonaBeans() {
        facesContext = FacesContext.getCurrentInstance();
    httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    requestContext = RequestContext.getCurrentInstance();
    }
   

public String buscarpersona(){
    PersonaDao personadao= new PersonaDao();
    persona = personadao.Buscar(persona);
    if (persona != null) {
            nombre= persona.getNombres();
            apellidop=persona.getApellidoPaterno();
            apellidom=persona.getApellidoMaterno();
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Busqueda Correta", ""+persona.getNombres());
            mensaje(facesMessage);
            
            return "Menu.xhtml";
    } else {
            
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Busqueda Error", "Invalid credentials");
            mensaje(facesMessage);
            return "RegistrarPersona.xhtml";
        }   
}

public void mensaje(FacesMessage msMessage){
        FacesContext.getCurrentInstance().addMessage(null, msMessage);
             
}
}
