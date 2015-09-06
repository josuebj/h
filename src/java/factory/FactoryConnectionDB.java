/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

/**
 *
 * @author Docente
 */
public class FactoryConnectionDB {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int POSTGRESQL = 3;
    public static String[] configMYSQL ={"hce","root","root"};
    public static ConexionBD open(int typeDB){
        switch(typeDB){
            case FactoryConnectionDB.MYSQL:
                return new MYSQLConnectionDB(configMYSQL);      
            default:
                return null;
        }
    }
            
}
