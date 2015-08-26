/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.HistoriaClinica;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceHistoriaClinica {
    public List<HistoriaClinica> listarHitoriaClinica();
    public HistoriaClinica BuscarHistoriaClinica(HistoriaClinica hc);
    public boolean registrarHistoriaClinica(HistoriaClinica hc);
    public boolean editarHistoriaClinica(HistoriaClinica hc);
    public boolean eliminarHistoriaClinica(HistoriaClinica hc);
    
}
