package org.example;

import org.example.personalLibrary.Conexion;
import org.example.personalLibrary.Menu;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.menuApp();

        /*
        try ( Connection cnx = Conexion.get_connection()) {

        } catch (SQLException e){
            throw new RuntimeException(e);
            //Capturando el error
        }

         */
    }
}