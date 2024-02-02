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
import Entidad.Matricula;

public class MatriculaDAO {

    private final conexiones conexionDB;

    public MatriculaDAO() {
        conexionDB = new conexiones();
    }

    // Método para insertar una nueva matrícula
    public boolean insertar(Matricula matricula) {
        Connection conexion = conexionDB.getConnection();
        String query = "INSERT INTO matricula (id_Alumno, nivel_m, grado_m, estado_m, metodo_Pago, monto_Pago, observaciones, id_Usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, matricula.getId_Alumno());
            ps.setString(2, matricula.getNivel_m());
            ps.setInt(3, matricula.getGrado_m());
            ps.setString(4, matricula.getEstado_m());
            ps.setString(5, matricula.getMetodo_Pago());
            ps.setDouble(6, matricula.getMonto_Pago());
            ps.setString(7, matricula.getObservaciones());
            ps.setString(8, matricula.getId_Usuario());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Matricula> obtenerTodasLasMatriculas() {
        List<Matricula> listaMatriculas = new ArrayList<>();
        Connection conexion = conexionDB.getConnection();
        String query = "SELECT * FROM matricula";
        try (PreparedStatement ps = conexion.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Matricula matricula = new Matricula(
                        rs.getInt("id_Matricula"),
                        rs.getInt("id_Alumno"),
                        rs.getString("nivel_m"),
                        rs.getInt("grado_m"),
                        rs.getString("estado_m"),
                        rs.getString("metodo_Pago"),
                        rs.getDouble("monto_Pago"),
                        rs.getString("observaciones"),
                        rs.getString("id_Usuario")
                );
                listaMatriculas.add(matricula);
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
        return listaMatriculas;
    }

    public Matricula buscarMatriculaPorID(int idMatricula) {
        Matricula matricula = null;
        Connection conexion = conexionDB.getConnection();
        String query = "SELECT * FROM matricula WHERE id_Matricula = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idMatricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                matricula = new Matricula(
                        rs.getInt("id_Matricula"),
                        rs.getInt("id_Alumno"),
                        rs.getString("nivel_m"),
                        rs.getInt("grado_m"),
                        rs.getString("estado_m"),
                        rs.getString("metodo_Pago"),
                        rs.getDouble("monto_Pago"),
                        rs.getString("observaciones"),
                        rs.getString("id_Usuario")
                );
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
        return matricula;
    }

    // Método para modificar una matrícula
    public boolean modificar(Matricula matricula) {
        Connection conexion = conexionDB.getConnection();
        String query = "UPDATE matricula SET id_Alumno=?, nivel_m=?, grado_m=?, estado_m=?, metodo_Pago=?, monto_Pago=?, observaciones=?, id_Usuario=? WHERE id_Matricula=?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, matricula.getId_Alumno());
            ps.setString(2, matricula.getNivel_m());
            ps.setInt(3, matricula.getGrado_m());
            ps.setString(4, matricula.getEstado_m());
            ps.setString(5, matricula.getMetodo_Pago());
            ps.setDouble(6, matricula.getMonto_Pago());
            ps.setString(7, matricula.getObservaciones());
            ps.setString(8, matricula.getId_Usuario());
            ps.setInt(9, matricula.getId_Matricula());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean eliminar(int idMatricula) {
        Connection conexion = conexionDB.getConnection();
        String query = "DELETE FROM matricula WHERE id_Matricula=?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idMatricula);

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
