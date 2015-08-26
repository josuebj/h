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

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
/**
 *
 * @author Berti
 */
@ManagedBean
@RequestScoped
public class HistoriaClinicaBeans implements Serializable{
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
    private final RequestContext requestContext;
    
    
    
    /**
     * Creates a new instance of HistoriaClinicaBeans
     */
    public HistoriaClinicaBeans() {
    facesContext = FacesContext.getCurrentInstance();
    httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    requestContext = RequestContext.getCurrentInstance();
    }
      
    
    
    
}
