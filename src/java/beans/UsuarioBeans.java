/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;




import daos.PersonaDao;
import entidades.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;


import daos.UsuarioDao;
import daos.UsuarioRolDao;
import entidades.Persona;
import entidades.UsuarioRol;

/**
 *
 * @author Berti
 */

@ManagedBean
@RequestScoped
public class UsuarioBeans{
    
    private Usuario usuario;
    private UsuarioRol usuariorol;
    
    
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
    private final RequestContext requestContext;
    private boolean loggedIn=false;
    
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioRol getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(UsuarioRol usuariorol) {
        this.usuariorol = usuariorol;
    }
    
    


    
    public UsuarioBeans(){
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        requestContext = RequestContext.getCurrentInstance();
        loggedIn = false;
    }
    public String login() {
        UsuarioDao usuarioDao = new UsuarioDao();
        
        usuario = usuarioDao.validarUser(usuario);

        if (usuario != null) {
              loggedIn = true;                  
                httpServletRequest.getSession().setAttribute("user", usuario.getUsuario_1());
                httpServletRequest.getSession().setAttribute("nombre", usuario.getPersona().getNombres());
                httpServletRequest.getSession().setAttribute("apellidos", usuario.getPersona().getApellidoPaterno()+" "+ usuario.getPersona().getApellidoMaterno());
                httpServletRequest.getSession().setAttribute("iduser", usuario.getIdUsuario());
                UsuarioRolDao usuariorolDao= new UsuarioRolDao();
                usuariorol = usuariorolDao.listarUsuarioRolU(usuario);
                httpServletRequest.getSession().setAttribute("rol", usuariorol.getRol().getRol());
                
              facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Usuario: "+usuario.getPersona().getNombres());
              mensaje(facesMessage);
              return "Inicio.xhtml";
        } else {
            loggedIn = false;
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            mensaje(facesMessage);
            return "Logueo.xhtml";
        }

    }
     public void mensaje(FacesMessage msMessage){
        FacesContext.getCurrentInstance().addMessage(null, msMessage);
        requestContext.addCallbackParam("loggedIn", loggedIn);     
     }

    
        

    
    
}
