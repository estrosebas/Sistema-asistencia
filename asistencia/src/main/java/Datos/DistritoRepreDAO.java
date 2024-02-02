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
import javax.swing.JOptionPane;
import Entidad.DistritoRepre;

/**
 *
 * @author estrosebas
 */
public class DistritoRepreDAO {

    private final conexiones conexionDB;

    public DistritoRepreDAO() {
        conexionDB = new conexiones();
    }

    public boolean insertar(DistritoRepre distritoRepre) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO distritorepre (distritoR) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setString(1, distritoRepre.getDistritoR());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DistritoRepre> obtenerDistritos() {
        List<DistritoRepre> distritos = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = conexionDB.getConnection(); // Asumiendo que tienes una clase que gestiona la conexión
            String query = "SELECT * FROM distritorepre"; // Asegúrate de que el nombre de la tabla y las columnas sean correctos
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_distritoR"); // Asegúrate de que el nombre de la columna es correcto
                String nombre = rs.getString("distritoR"); // Asegúrate de que el nombre de la columna es correcto
                distritos.add(new DistritoRepre(id, nombre));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos para evitar fugas de memoria
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return distritos;
    }

    public DistritoRepre buscarDistritoPorId(int idDistrito) {
        DistritoRepre distritoRepre = null;

        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM distritorepre WHERE id_distritoR = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idDistrito);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                String distritoA = rs.getString("distritoR");

                
                distritoRepre = new DistritoRepre(idDistrito, distritoA);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return distritoRepre;
    }

    public boolean modificar(DistritoRepre distritoRepre) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "UPDATE distritorepre SET distritoR = ? WHERE id_distritoR = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setString(1, distritoRepre.getDistritoR());
            ps.setInt(2, distritoRepre.getId_distritoRepre());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int iddistrito) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "DELETE FROM distritorepre WHERE id_distritoAlum=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, iddistrito);  // Asumiendo que DNI es un string, si es numérico, usa setInt

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {  // Código de error para violación de llave foránea
                // Manejar específicamente la violación de la llave foránea
                System.out.println("No se puede eliminar el distrito porque está en uso");
                JOptionPane.showMessageDialog(null, "Error al eliminar, el distrito esta en uso");
            } else {
                // Otros errores SQL
                e.printStackTrace();
            }
            return false;
        }
    }
}
