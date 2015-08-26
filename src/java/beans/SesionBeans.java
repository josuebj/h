/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author DReyna
 */
@ManagedBean(name = "sesionbeans")
@RequestScoped
public class SesionBeans {
    private String usersesion;
    private String nombre;
    private String apellidos;
    private String rol;
     private String active;
     private String inactive;
     
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
    private final RequestContext requestContext;
    private boolean loggedIn = false;

    

    
    public String getUsersesion() {
        return usersesion;
    }

    public void setUsersesion(String usersesion) {
        this.usersesion = usersesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    
    

    public SesionBeans() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        requestContext = RequestContext.getCurrentInstance();
        if(httpServletRequest.getSession().getAttribute("user")!=null){
            usersesion = httpServletRequest.getSession().getAttribute("user").toString();
            nombre = httpServletRequest.getSession().getAttribute("nombre").toString();
            apellidos=httpServletRequest.getSession().getAttribute("apellidos").toString();
            rol=httpServletRequest.getSession().getAttribute("rol").toString();
            if(rol=="Admin"){
             active ="active";
             inactive="in active";
            }else{
            
            }            
             
        }
    }
    public String cerrarSesion(){
        httpServletRequest.getSession().removeAttribute("user");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN, "Cerrar Sesion", "Sesion Cerrada Correctamente");
        mensaje(facesMessage);
        return "Logueo.xhtml";
    }
     public void mensaje(FacesMessage msMessage){
        FacesContext.getCurrentInstance().addMessage(null, msMessage);
        requestContext.addCallbackParam("loggedIn", loggedIn);     
     }
    
}
