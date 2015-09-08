/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Admision;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Berti
 */
@ManagedBean
@RequestScoped
public class AdmisionBeans {
    private Admision admision;
    /**
     * Creates a new instance of AdmisionBeans
     */
    public AdmisionBeans() {
    }
    
}
