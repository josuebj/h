/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.GradoInstruccionDao;
import entidades.GradoInstruccion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Berti
 */
@ManagedBean
@ViewScoped
public class GradoInstruccionBeans {

    
    private String codtp;
    private GradoInstruccion gi;
    private List<SelectItem> tipopersonal;
    private List<SelectItem> rangomilitar;
    /**
     * Creates a new instance of GradoInstruccion
     */
    public GradoInstruccionBeans() {
    }
    public List<SelectItem> listarTipoPersonal(){
        tipopersonal = new ArrayList<SelectItem>();
        GradoInstruccionDao gidao= new GradoInstruccionDao();
        List<GradoInstruccion> listtp = gidao.TipoPersonal();       
        tipopersonal.clear();      
        for(GradoInstruccion tp:listtp){
            SelectItem selectItem = new SelectItem(tp.getTipoPersonal(),tp.getNombre());
            tipopersonal.add(selectItem);
            
        }       
        return tipopersonal;      
    }
    
    public List<SelectItem> listarRangoMilitar(){
        rangomilitar = new ArrayList<SelectItem>();
        GradoInstruccionDao gidao= new GradoInstruccionDao();
        List<GradoInstruccion> listrm = gidao.RangoMilitar(codtp);       
        rangomilitar.clear();      
        for(GradoInstruccion rm:listrm){
            SelectItem selectItem = new SelectItem(rm.getIdGradoInstruccion(),rm.getNombre());
            rangomilitar.add(selectItem);
            
        }       
        return rangomilitar;      
    }

    public String getCodtp() {
        return codtp;
    }

    public void setCodtp(String codtp) {
        this.codtp = codtp;
    }

    public GradoInstruccion getGi() {
        return gi;
    }

    public void setGi(GradoInstruccion gi) {
        this.gi = gi;
    }
    
    
    
    
    
}
