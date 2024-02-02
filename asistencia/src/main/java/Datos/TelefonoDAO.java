/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author estrosebas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidad.Telefono;

public class TelefonoDAO {
    private final conexiones conexionDB;
    public TelefonoDAO() {
        conexionDB = new conexiones();
    }
    public boolean insertar(Telefono telefono) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO telefono (telefono) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, telefono.getTelefono());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Telefono> obtenerTelefonos() {
        List<Telefono> telefonos = new ArrayList<>();
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM telefono";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_telefono");
                int numero = rs.getInt("telefono");
                telefonos.add(new Telefono(id, numero));
            }
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return telefonos;
    }

    public Telefono buscarTelefonoPorId(int idTelefono) {
        Telefono telefono = null;
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM telefono WHERE id_telefono = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idTelefono);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int numero = rs.getInt("telefono");
                telefono = new Telefono(idTelefono, numero);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return telefono;
    }

    public boolean modificar(Telefono telefono) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "UPDATE telefono SET telefono = ? WHERE id_telefono = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, telefono.getTelefono());
            ps.setInt(2, telefono.getId_telefono());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idTelefono) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "DELETE FROM telefono WHERE id_telefono=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idTelefono);

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (SQLException e) {
            // Aquí puedes manejar errores específicos de SQL si es necesario
            e.printStackTrace();
            return false;
        }
    }
}
