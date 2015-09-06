/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import entidades.Departamento;
/**
 *
 * @author DavidReyna
 */
public interface InterfaceDepartamento {
    public List<Departamento> list();
    public List<Departamento> list(int id);
    public boolean edit(Departamento departamento);
    public boolean save(Departamento departamento);
    public boolean delete(int id);
}
