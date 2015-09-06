/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Berti
 */
@ManagedBean
@SessionScoped
public class BeanSession {
    private int idhc;

    /**
     * Creates a new instance of BeanSession
     */
    public BeanSession() {
        idhc= idhc;
    }

    public int getIdhc() {
        return idhc;
    }

    public void setIdhc(int idhc) {
        this.idhc = idhc;
    }
    
}
