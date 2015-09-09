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
    public List<HistoriaClinica> listarHC();
    public List<HistoriaClinica> listarHCS(int idhc);
    public HistoriaClinica BuscarHC(HistoriaClinica hc);
    public int NumEpidosio(int idp);
    public boolean registrarHC(HistoriaClinica hc);
    public boolean editarHC(HistoriaClinica hc);
    public boolean eliminarHC(HistoriaClinica hc);
    
}
