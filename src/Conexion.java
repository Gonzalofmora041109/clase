
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RLCR
 */
public class Conexion {
    private static Connection  cnx=null;
    
    public static  Connection obtener()throws SQLException,ClassNotFoundException {
        if(cnx==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection("jdbc:mysql://localhost/ventas","root","root");
            
            }catch(SQLException e){
                throw new SQLException (e);
            
            }
        }
    return cnx;
    }
    public boolean ejecutainsert(String sql)throws ClassNotFoundException {
     
        try{
            cnx=obtener();
            Statement sentencia=cnx.createStatement();
            sentencia.executeUpdate(sql);
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        } 
        return true;
    }
    
}
