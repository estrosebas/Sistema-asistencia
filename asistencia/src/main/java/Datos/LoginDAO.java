/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidad.Login;

/**
 *
 * @author estrosebas
 */
public class LoginDAO {

    private final conexiones conexionDB;

    public LoginDAO() {
        conexionDB = new conexiones();
    }

    public Login buscarUsuario(String id_usuario) {
        Login login = null;
        Connection conexion = conexionDB.getConnection();
        String query = "SELECT * FROM iniciosesion WHERE id_Usuario = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            // Cambiado a setString ya que id_usuario es una cadena
            ps.setString(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String contra = rs.getString("contra");
                int id_admini = rs.getInt("id_admini");
                login = new Login(id_usuario, contra, id_admini);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return login;
    }

    public Login devolverNombre(int idadmini) {
        Login login = null;
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM administrador WHERE id_Admini = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idadmini);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre_Admini");
                login = new Login(idadmini, nombre);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
