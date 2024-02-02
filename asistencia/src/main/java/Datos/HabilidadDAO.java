/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidad.Habilidad;

/**
 *
 * @author estrosebas
 */
public class HabilidadDAO {
    private final conexiones conexionDB;

    public HabilidadDAO() {
        conexionDB = new conexiones();
    }
    public boolean insertar(Habilidad habilidad) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO habilidad (habilidad) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setString(1, habilidad.getHabilidad());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Habilidad> obtenerHabilidades() {
        List<Habilidad> habilidades = new ArrayList<>();
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM habilidad";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_habilidad");
                String nombre = rs.getString("habilidad");
                habilidades.add(new Habilidad(id, nombre));
            }
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return habilidades;
    }

    public Habilidad buscarHabilidadPorId(int idHabilidad) {
        Habilidad habilidad = null;
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM habilidad WHERE id_habilidad = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idHabilidad);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("habilidad");
                habilidad = new Habilidad(idHabilidad, nombre);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return habilidad;
    }

    public boolean modificar(Habilidad habilidad) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "UPDATE habilidad SET habilidad = ? WHERE id_habilidad = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setString(1, habilidad.getHabilidad());
            ps.setInt(2, habilidad.getId_habilidad());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idHabilidad) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "DELETE FROM habilidad WHERE id_habilidad=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idHabilidad);

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (SQLException e) {
            // Manejar errores específicos de SQL si es necesario
            e.printStackTrace();
            return false;
        }
    }
}
