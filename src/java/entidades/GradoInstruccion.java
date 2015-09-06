package entidades;
// Generated 06-sep-2015 6:46:45 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * GradoInstruccion generated by hbm2java
 */
public class GradoInstruccion  implements java.io.Serializable {


     private Integer idGradoInstruccion;
     private String tipoPersonal;
     private String rangoMilitar;
     private String nombre;
     private Date fechaReg;
     private Set<Persona> personas = new HashSet<Persona>(0);

    public GradoInstruccion() {
    }

    public GradoInstruccion(String tipoPersonal, String rangoMilitar, String nombre, Date fechaReg, Set<Persona> personas) {
       this.tipoPersonal = tipoPersonal;
       this.rangoMilitar = rangoMilitar;
       this.nombre = nombre;
       this.fechaReg = fechaReg;
       this.personas = personas;
    }
   
    public Integer getIdGradoInstruccion() {
        return this.idGradoInstruccion;
    }
    
    public void setIdGradoInstruccion(Integer idGradoInstruccion) {
        this.idGradoInstruccion = idGradoInstruccion;
    }
    public String getTipoPersonal() {
        return this.tipoPersonal;
    }
    
    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }
    public String getRangoMilitar() {
        return this.rangoMilitar;
    }
    
    public void setRangoMilitar(String rangoMilitar) {
        this.rangoMilitar = rangoMilitar;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaReg() {
        return this.fechaReg;
    }
    
    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }
    public Set<Persona> getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }




}


