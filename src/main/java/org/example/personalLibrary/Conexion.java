package org.example.personalLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Este metodo nos permite realizar la conexión con mysql.
    public static Connection get_connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");
            if(connection != null){
                System.out.println("Conexion exitosa");
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
