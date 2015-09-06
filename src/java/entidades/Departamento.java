/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author DavidReyna
 */
public class Departamento {
    private int iddpto;
    private String dpto;
    private int costos;
    private int status;

    public Departamento() {
    }
    public Departamento(String dpto, int costos, int status) {
        this.dpto = dpto;
        this.costos = costos;
        this.status = status;
    }

    public int getIddpto() {
        return iddpto;
    }

    public void setIddpto(int iddpto) {
        this.iddpto = iddpto;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public int getCostos() {
        return costos;
    }

    public void setCostos(int costos) {
        this.costos = costos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
