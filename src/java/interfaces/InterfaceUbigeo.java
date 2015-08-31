/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Ubigeo;
import java.util.List;

/**
 *
 * @author Berti
 */
public interface InterfaceUbigeo {
    public List<Ubigeo> listarDepartamento();
    public List<Ubigeo> listarProvincia( String u);
    public List<Ubigeo> listarDistrito(String d, String p);
    
}
