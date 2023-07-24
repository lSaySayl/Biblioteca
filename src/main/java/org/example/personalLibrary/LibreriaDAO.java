package org.example.personalLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LibreriaDAO {

    public static void createBookDB(LibreariaModel libMo) {
        Conexion data_connect = new Conexion();

        try (Connection conexion = data_connect.get_connection()) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "INSERT INTO libro (bookname,author, isbn,pages,category) VALUES (?,?,?,?,?)";
                preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setString(1, libMo.getBookName());
                preparedStatement.setString(2, libMo.getAuthor());
                preparedStatement.setString(3, libMo.getIsbn());
                preparedStatement.setInt(4, libMo.getPages());
                preparedStatement.setString(5, libMo.getCategory());
                preparedStatement.execute();

                System.out.println("Libro creado correctamente");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
            //Capturando el error
        }

    }

    public static void readBookDB() {

        Conexion data_connect = new Conexion();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection conexion = data_connect.get_connection()) {
            String query = "SELECT * FROM libro";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_book"));
                System.out.println("Nombre: " + resultSet.getString("bookname"));
                System.out.println("Autor: " + resultSet.getString("author"));
                System.out.println("ISBN: " + resultSet.getString("isbn"));
                System.out.println("Páginas: " + resultSet.getInt("pages"));
                System.out.println("Categoría: " + resultSet.getString("category"));
                System.out.println("");


            }

        } catch (SQLException e) {
            System.out.println(e);


        }


    }

    public static void deleteBookDB(int id_book) {
        Conexion data_connect = new Conexion();

        try (Connection conexion = data_connect.get_connection()) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "DELETE FROM libro WHERE id_book = ?";
                preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1, id_book);
                preparedStatement.executeUpdate();

                System.out.println("Libro eliminado correctamente");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
            //Capturando el error
        }

    }

    public static void updateBookDB (LibreariaModel libMo) {
        Conexion data_connect = new Conexion();

            try (Connection conexion = data_connect.get_connection()) {
                PreparedStatement preparedStatement = null;

                try {
                    String query = "UPDATE libro SET bookname = ?, author = ?, isbn = ?, pages = ?, category = ? WHERE id_book = ?";
                    preparedStatement = conexion.prepareStatement(query);
                    preparedStatement.setString(1, libMo.getBookName());
                    preparedStatement.setString(2, libMo.getAuthor());
                    preparedStatement.setString(3, libMo.getIsbn());
                    preparedStatement.setInt(4, libMo.getPages());
                    preparedStatement.setString(5, libMo.getCategory());
                    preparedStatement.setInt(6, libMo.getId_book());
                    preparedStatement.executeUpdate();


                    System.out.println("Libro actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
                //Capturando el error
            }

    }


}
