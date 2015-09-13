package entidades;
// Generated 11-sep-2015 8:21:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cie10 generated by hbm2java
 */
public class Cie10  implements java.io.Serializable {


     private String idCie10;
     private String descripcion;
     private String grupo;
     private Set<Antecedente> antecedentes = new HashSet<Antecedente>(0);
     private Set<DetalleHis> detalleHises = new HashSet<DetalleHis>(0);

    public Cie10() {
    }

	
    public Cie10(String idCie10) {
        this.idCie10 = idCie10;
    }
    public Cie10(String idCie10, String descripcion, String grupo, Set<Antecedente> antecedentes, Set<DetalleHis> detalleHises) {
       this.idCie10 = idCie10;
       this.descripcion = descripcion;
       this.grupo = grupo;
       this.antecedentes = antecedentes;
       this.detalleHises = detalleHises;
    }
   
    public String getIdCie10() {
        return this.idCie10;
    }
    
    public void setIdCie10(String idCie10) {
        this.idCie10 = idCie10;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public Set<Antecedente> getAntecedentes() {
        return this.antecedentes;
    }
    
    public void setAntecedentes(Set<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }
    public Set<DetalleHis> getDetalleHises() {
        return this.detalleHises;
    }
    
    public void setDetalleHises(Set<DetalleHis> detalleHises) {
        this.detalleHises = detalleHises;
    }




}


