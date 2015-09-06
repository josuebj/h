/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import factory.ConexionBD;
import factory.FactoryConnectionDB;
import interfaces.InterfaceDepartamento;
import entidades.Departamento;

/**
 *
 * @author DavidReyna
 */
public class DepartamentoDAO implements InterfaceDepartamento{
    ConexionBD conn;
    @Override
    public List<Departamento> list() {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM departamento");
        List<Departamento> list = new ArrayList<Departamento>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
            Departamento prov = new Departamento();
            prov.setIddpto(rs.getInt("iddepartamento"));
            prov.setDpto(rs.getString("departamento"));
            prov.setCostos(rs.getInt("Centro_Costos"));
            prov.setStatus(rs.getInt("Status"));
            list.add(prov);
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }
    @Override
    public List<Departamento> list(int id) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM departamento WHERE iddepartamento=").append(id);
        List<Departamento> list = new ArrayList<Departamento>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
            Departamento prov = new Departamento();
            prov.setIddpto(rs.getInt("iddepartamento"));
            prov.setDpto(rs.getString("departamento"));
            prov.setCostos(rs.getInt("Centro_Costos"));
            prov.setStatus(rs.getInt("Status"));
            list.add(prov);
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }
    @Override
    public boolean edit(Departamento departamento) {
       this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean save = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE departamento SET iddepartamento = ").append(departamento.getIddpto());
            sql.append(", departamento = '").append(departamento.getDpto());
            sql.append("', Centro_Costos = ").append(departamento.getCostos());
            sql.append(", Status = ").append(departamento.getStatus()).append(" WHERE iddepartamento = ").append(departamento.getIddpto());
            this.conn.execute(sql.toString());
            save = true;
            //System.out.println(departamento.getDpto());
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
//        System.out.println(departamento.getIddpto());
//        System.out.println(departamento.getDpto());
//        System.out.println(departamento.getCostos());
//        System.out.println(departamento.getStatus());
        return save;
    }
    @Override
    public boolean save(Departamento departamento) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean save = false;
        try {
//            System.out.println(departamentp.getId()+", "+departamentp.getProv()+", "+departamentp.getDir()+", "+departamentp.getRuc()+", "+departamentp.getTel()+", "+departamentp.getEst());
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO departamento(iddepartamento, departamento, Centro_Costos, Status) VALUES(").append("NULL");
                sql.append(", '").append(departamento.getDpto());
                sql.append("', ").append(departamento.getCostos());
                sql.append(", ").append(departamento.getStatus()).append(")");
                //String sql1 = "INSERT INTO Proveedor(iddepartamentp)VALUES(10)";
                this.conn.execute(sql.toString());
                save = true;
        } catch (Exception e) {
            this.conn.close();
        }        
        return save;
    }

    @Override
    public boolean delete(int id) {
         this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM departamento WHERE iddepartamento = ").append(id);
            this.conn.execute(sql.toString());
            delete = true;
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
