/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.HistoriaClinicaDao;
import entidades.HistoriaClinica;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sun.java2d.pipe.RenderBuffer;

/**
 *
 * @author Berti
 */
@ManagedBean
@ViewScoped
public class Treeview {
 private HistoriaClinica historiaclinica;
    
    private List<HistoriaClinicaBeans> hc;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public Treeview() {
    }
    public String registrarHC(){
        HistoriaClinicaDao hcdao= new HistoriaClinicaDao();
        hcdao.registrarHC(historiaclinica);
        historiaclinica = new HistoriaClinica();
        return "ggg";
        
    }

    
}
