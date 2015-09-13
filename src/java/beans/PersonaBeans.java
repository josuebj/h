/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.PersonaDao;
import entidades.Persona;
import entidades.TipoPersona;
import entidades.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Berti
 */
@ManagedBean
@RequestScoped
public class PersonaBeans {
    private Persona persona;
    private String gp;
    private Usuario usuario;
    private TipoPersona tipopersona;
    private FileUploadEvent foto;
    

    public String getGp() {
        return gp;
    }

    public void setGp(String gPp) {
        this.gp = gp;
    }
    
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    
    public PersonaBeans() {
        persona= new Persona();
    }
   

public String buscarpersona(){
            gp="null";
    PersonaDao personadao= new PersonaDao();
    persona = personadao.Buscar(persona);
    if (persona != null) {
        
           // facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Busqueda Correta", ""+persona.getNombres());
          //  mensaje(facesMessage);
            gp="g";
            return "Menu.xhtml";
    } else {

            return "RegistrarPersona.xhtml";
        }   
}
public String registrarpersona(){

    PersonaDao personadao= new PersonaDao();
 /*   UploadedFile file= foto.getFile();
    
    personadao.subirFoto(file.getContents(), persona.getDni().toString());
*/
    return "Menu.xhtml";
}

    public FileUploadEvent getFoto() {
        return foto;
    }

    public void setFoto(FileUploadEvent foto) {
        this.foto = foto;
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

    public TipoPersona getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(TipoPersona tipopersona) {
        this.tipopersona = tipopersona;
    }

}
